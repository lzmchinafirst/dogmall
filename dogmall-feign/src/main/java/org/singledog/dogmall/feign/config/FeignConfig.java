package org.singledog.dogmall.feign.config;

import feign.Logger;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The openfeign log
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@Configuration
public class FeignConfig {

    @Value("feign.logger.level")
    private String loggerLevel;

    @Bean
    Logger.Level feignLoggerLevel() {
        if (StringUtils.equals("FULL", loggerLevel)) {
            return Logger.Level.FULL;
        } else if (StringUtils.equals("BASIC", loggerLevel)) {
            return Logger.Level.BASIC;
        } else if (StringUtils.equals("HEADERS", loggerLevel)) {
            return Logger.Level.HEADERS;
        } else if (StringUtils.equals("NONE", loggerLevel)) {
            return Logger.Level.NONE;
        } else {
            return Logger.Level.NONE;
        }
    }
}
