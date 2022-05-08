package org.singledog.dogmall.feign.core;

import feign.Logger;
import org.springframework.cloud.openfeign.FeignLoggerFactory;

/**
 * Feign log factory,create {@link LevelLogger}.
 *
 * @author ZheMing Liu
 * @since 1.0.0-RELEASE
 */
public class LevelLoggerFactory implements FeignLoggerFactory {

    private Logger logger;

    public LevelLoggerFactory() {
    }

    public LevelLoggerFactory(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Logger create(Class<?> type) {
        return this.logger != null ? this.logger : new LevelLogger();
    }
}
