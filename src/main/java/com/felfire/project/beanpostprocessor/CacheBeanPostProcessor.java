package com.felfire.project.beanpostprocessor;

import com.felfire.project.annotation.MyCache;
import com.felfire.project.annotationprocessor.CacheAnnotationProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * BeanPostProcessor для создания кэширующей прокси
 */
@Component
public class CacheBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Object> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(MyCache.class)) {
            map.put(beanName,bean);
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (map.containsKey(beanName)) {
            return CacheAnnotationProcessor.cache(map.get(beanName));
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
