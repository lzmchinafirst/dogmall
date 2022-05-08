package org.singledog.dogmall.core.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;

/**
 * spring-listener bean
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@EnableAsync
@Configuration
public class AsyncConfig implements AsyncConfigurer, ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * Return global {@link Executor}
     */
    @Override
    public Executor getAsyncExecutor() {
        return (Executor) applicationContext.getBean("executor");
    }

    /**
     * Async task error handle,publish event to listener
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) -> applicationContext.publishEvent(new AsyncErrorEvent(new AsyncErrorEventDescribe(ex, method, params)));
    }

    /**
     * Set {@link #applicationContext}
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
