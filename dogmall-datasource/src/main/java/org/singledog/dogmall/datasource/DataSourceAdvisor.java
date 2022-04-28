package org.singledog.dogmall.datasource;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * DataSource advisor
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
public class DataSourceAdvisor implements PointcutAdvisor {

    /**
     * Get the proxy method interceptor
     */
    @Override
    public Advice getAdvice() {
        return new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                Object proceed = null;
                long start = System.currentTimeMillis();
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
                    long end = System.currentTimeMillis();
                    log.info("The proxy method {} spend {} ms", method == null ? null : method.getName(), end - start);
                }
                return proceed;
            }
        };
    }

    @Override
    public boolean isPerInstance() {
        return false;
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
     * Register the processor
     */
    @Bean
    @ConditionalOnMissingBean(DefaultAdvisorAutoProxyCreator.class)
    public DefaultAdvisorAutoProxyCreator registerProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }
}
