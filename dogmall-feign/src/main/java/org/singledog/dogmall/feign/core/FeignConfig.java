package org.singledog.dogmall.feign.core;

import feign.Logger;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The spring-cloud openfeign log configuration.
 *
 * @author ZheMing Liu
 * @since 1.0.0-RELEASE
 */
@RefreshScope
@Configuration(proxyBeanMethods = false)
public class FeignConfig {

    @Value("${feign.log.level:none}")
    private String level;

    @Bean
    @ConditionalOnProperty(name = "feign.factory.enable", havingValue = "true")
    public LevelLoggerFactory feignLoggerFactory() {
        return new LevelLoggerFactory();
    }

    @Bean
    public Logger.Level level() {
        if (StringUtils.equalsIgnoreCase(Logger.Level.NONE.name(), level)) {
            return Logger.Level.NONE;
        }
        if (StringUtils.equalsIgnoreCase(Logger.Level.BASIC.name(), level)) {
            return Logger.Level.BASIC;
        }
        if (StringUtils.equalsIgnoreCase(Logger.Level.HEADERS.name(), level)) {
            return Logger.Level.HEADERS;
        }
        if (StringUtils.equalsIgnoreCase(Logger.Level.FULL.name(), level)) {
            return Logger.Level.FULL;
        }
        return Logger.Level.NONE;
    }
}
