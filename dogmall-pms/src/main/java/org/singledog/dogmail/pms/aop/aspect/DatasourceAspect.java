package org.singledog.dogmail.pms.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.singledog.dogmail.datasource.Datasource;
import org.singledog.dogmail.datasource.DatasourceContext;
import org.singledog.dogmail.datasource.DatasourceType;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Datasource change
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@Slf4j
@Aspect
@Order(0)
@Component
public class DatasourceAspect {

    @Pointcut("@annotation(org.singledog.dogmail.datasource.Datasource)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object aroudAdvice(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Datasource datasource = method.getAnnotation(Datasource.class);
        DatasourceType type = datasource.value();
        log.info("The thread " + Thread.currentThread().getName() + " datasource is {}", type);
        DatasourceContext.setDatasourceType(type);
        Object proceed = point.proceed();
        DatasourceContext.removeDatasource();
        return proceed;
    }
}
