package com.felfire.project.annotationprocessor;

import com.felfire.project.annotation.Mutator;
import com.felfire.project.annotation.MyCache;
import lombok.SneakyThrows;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Обработчик аннотации Cache из задачника
 */

public class CacheAnnotationProcessor {
    @SneakyThrows
    public static Object cache(Object object) {
        return Enhancer.create(object.getClass(), new CacheMethodInterceptor(object));
    }
}

class CacheMethodInterceptor implements MethodInterceptor {
    private Object object;
    private Map<Method, Object> cache = new HashMap<>();
    private boolean isModified = true;


    CacheMethodInterceptor(Object object) {
        this.object = object;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if (method.isAnnotationPresent(Mutator.class)) {
            isModified = true;
            return method.invoke(object, args);
        }

        Class<?> objClass = object.getClass();
        MyCache annotation = objClass.getAnnotation(MyCache.class);
        String[] methodNames = annotation.value();
        if (methodNames.length == 0)
            return simpleCache(method, args);
        else {
            for (String name : methodNames) {
                if (method.getName().equals(name)) return simpleCache(method, args);
            }
        }
        return method.invoke(object, args);
    }


    private Object simpleCache(Method method, Object... args)
            throws IllegalAccessException, InvocationTargetException {
        if (cache.containsKey(method) && !isModified) {
            return cache.get(method);
        } else {
            Object result = method.invoke(object, args);
            if (method.getReturnType() != void.class) cache.put(method, result);
            isModified = false;
            return result;
        }
    }


}