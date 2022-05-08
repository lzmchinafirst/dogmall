package org.singledog.dogmall.redis.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Record the proxy method time spend
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@Order(-1)
@Component
@Aspect
@Slf4j
public class TimeSpendAspect {

    /**
     * The advisor pointcut
     */
    @Pointcut("@annotation(org.singledog.dogmall.redis.annotation.TimeSpend)")
    public void pointcut() {

    }

    /**
     * The around advice
     *
     * @return the proxy method return value
     */
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        long start = System.currentTimeMillis();
        Object proceed = point.proceed();
        long end = System.currentTimeMillis();
        log.info("The proxy method {} spend {} ms", method.getName(), end - start);
        return proceed;
    }
}
