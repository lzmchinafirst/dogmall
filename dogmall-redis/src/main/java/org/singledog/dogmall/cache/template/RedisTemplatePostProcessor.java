package org.singledog.dogmall.cache.template;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * Spring boot auto config {@link RedisTemplate},the {@link RedisTemplate} bean post process.
 * Set the key serialize type is {@link String},the value serialize type is JSON.
 *
 * @author Zheming Liu
 * @since 1.0.0-RELEASE
 */
@EnableAsync
@Component
@ConditionalOnBean({RedisTemplate.class, StringRedisTemplate.class})
public class RedisTemplatePostProcessor implements BeanPostProcessor {

    /**
     * Set the {@link RedisTemplate} serialize type
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof RedisTemplate && !(bean instanceof StringRedisTemplate)) {
            RedisTemplate redisTemplate = (RedisTemplate) bean;
            redisTemplate.setKeySerializer(RedisSerializer.string());
            redisTemplate.setValueSerializer(RedisSerializer.json());
            redisTemplate.setHashKeySerializer(RedisSerializer.string());
            redisTemplate.setHashValueSerializer(RedisSerializer.json());
        }
        return bean;
    }
}
