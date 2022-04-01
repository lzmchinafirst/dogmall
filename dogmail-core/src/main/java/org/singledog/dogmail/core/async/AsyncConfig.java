package org.singledog.dogmail.core.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
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
public class AsyncConfig implements AsyncConfigurer, ApplicationContextAware, AsyncUncaughtExceptionHandler {

    private ApplicationContext applicationContext;

    /**
     * The project thread pool
     */
    @Override
    public Executor getAsyncExecutor() {
        if (applicationContext.getBean(Executor.class) == null) {
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
        return applicationContext.getBean(Executor.class);
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return this::handleUncaughtException;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * Async task error handle,publish event to listener
     */
    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        applicationContext.publishEvent(new AsyncErrorEvent(new AsyncErrorEventDescribe(ex, method, params)));
    }
}
