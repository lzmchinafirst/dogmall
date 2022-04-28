package org.singledog.dogmall.datasource;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.Ordered;

import java.lang.reflect.Method;

/**
 * DataSource advisor
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@Slf4j
public class DataSourceAdvisor extends AbstractPointcutAdvisor implements InitializingBean {

    /**
     * Get the proxy method interceptor
     */
    @Override
    public Advice getAdvice() {
        return new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                Object proceed = null;
                Method method = null;
                try {
                    method = invocation.getMethod();
                    DataSource dataSource = method.getAnnotation(DataSource.class);
                    DataSourceType type = dataSource.value();
                    log.info("The thread " + Thread.currentThread().getName() + " datasource is {}", type);
                    DataSourceContext.setDatasourceType(type);
                    proceed = invocation.proceed();
                } finally {
                    DataSourceContext.removeDatasource();
                }
                return proceed;
            }
        };
    }

    /**
     * Get the target pointcut
     */
    @Override
    public Pointcut getPointcut() {
        return new Pointcut() {
            @Override
            public ClassFilter getClassFilter() {
                return ClassFilter.TRUE;
            }

            @Override
            public MethodMatcher getMethodMatcher() {
                return new MethodMatcher() {
                    @Override
                    public boolean matches(Method method, Class<?> targetClass) {
                        return matches(method, targetClass, null);
                    }

                    @Override
                    public boolean isRuntime() {
                        return false;
                    }

                    @Override
                    public boolean matches(Method method, Class<?> targetClass, Object... args) {
                        return method.getAnnotation(DataSource.class) != null;
                    }
                };
            }
        };
    }

    /**
     * Set the advisor order
     */
    @Override
    public void afterPropertiesSet() {
        setOrder(Ordered.LOWEST_PRECEDENCE - 1);
    }
}
