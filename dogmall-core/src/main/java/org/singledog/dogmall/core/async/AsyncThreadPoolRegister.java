package org.singledog.dogmall.core.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class AsyncThreadPoolRegister {

    /**
     * Create global {@link Executor}
     */
    @Bean("executor")
    public Executor registerExecutor() {
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
}
