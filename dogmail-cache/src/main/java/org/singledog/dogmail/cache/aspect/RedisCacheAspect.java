package org.singledog.dogmail.cache.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Redis cache aspect,enhancer by spring AOP
 *
 * @author Zheming Liu
 * @see org.singledog.dogmail.cache.annotation.Cache
 * @since 1.0.0-RELEASE
 */
@Aspect
@Component
@Order(1)
public class RedisCacheAspect {

    @Pointcut("@annotation(org.singledog.dogmail.cache.annotation.Cache)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();
    }

}
