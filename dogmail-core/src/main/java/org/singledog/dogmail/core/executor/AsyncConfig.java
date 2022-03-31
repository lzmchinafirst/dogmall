package org.singledog.dogmail.core.executor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * spring-async config
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@Configuration(proxyBeanMethods = false)
@Slf4j
public class AsyncConfig implements AsyncConfigurer, BeanFactoryAware, AsyncUncaughtExceptionHandler {

    private BeanFactory beanFactory;

    /**
     * The project thread pool
     */
    @Override
    public Executor getAsyncExecutor() {
        if (beanFactory.getBean(Executor.class) == null) {
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
            taskExecutor.setCorePoolSize(availableProcessors * 2 + 1);
            taskExecutor.setQueueCapacity(1200);
            taskExecutor.setMaxPoolSize(128);
            taskExecutor.setKeepAliveSeconds(5);
            taskExecutor.setAllowCoreThreadTimeOut(false);
            taskExecutor.setThreadFactory(Executors.defaultThreadFactory());
            taskExecutor.setAwaitTerminationSeconds(30);
            taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
            taskExecutor.initialize();
            return taskExecutor;
        }
        return beanFactory.getBean(Executor.class);
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return this::handleUncaughtException;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    /**
     * async task error handle,the default handle is try again
     */
    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        log.error(ex.getMessage(), ex);
        log.error("Method {} async execute error", method.getName());
        Class<?> targetClass = method.getDeclaringClass();
        Object bean = beanFactory.getBean(targetClass);
        log.error("Method {} try again", method.getName());
        try {
            method.invoke(bean, params);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            log.error("Method {} async error", method.getName());
        }
    }
}
