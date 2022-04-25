package org.singledog.dogmail.pms.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Time spend
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@Slf4j
@Aspect
@Order(-1)
@Component
public class TimeSpendAspect {

    @Pointcut("@annotation(org.singledog.dogmail.pms.aop.annotation.TimeSpend)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object aroudAdvice(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        long start = System.currentTimeMillis();
        Object proceed = point.proceed();
        long end = System.currentTimeMillis();
        log.info("The method {} spend {} ms", signature.getMethod().getName(), end - start);
        return proceed;
    }
}
