package org.singledog.dogmall.feign.core;

import feign.Logger;
import lombok.extern.slf4j.Slf4j;

/**
 * Print feign log by level.
 *
 * @author ZheMing Liu
 * @since 1.0.0-RELEASE
 */
@Slf4j
public class LevelLogger extends Logger {

    @Override
    protected void log(String configKey, String format, Object... args) {
        if (log.isTraceEnabled()) {
            log.trace(String.format(methodTag(configKey) + format, args));
            return;
        }
        if (log.isDebugEnabled()) {
            log.debug(String.format(methodTag(configKey) + format, args));
            return;
        }
        if (log.isInfoEnabled()) {
            log.info(String.format(methodTag(configKey) + format, args));
            return;
        }
        if (log.isWarnEnabled()) {
            log.warn(String.format(methodTag(configKey) + format, args));
            return;
        }
        if (log.isErrorEnabled()) {
            log.error(String.format(methodTag(configKey) + format, args));
        }
    }
}
