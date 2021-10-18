package com.jiangtao.utils;

import com.jiangtao.distribute.Handler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * @Author: jiangtao
 * @Date: 2021/10/18 19:10
 */
public class AnnotationUtils {
    public static Map<String, Method> getAllHandler() throws ClassNotFoundException {
        Map<String, Method> map = new ConcurrentHashMap<>();
        List<Class> list = ClassUtils.getAllClasses();
        list.forEach(aClass -> {
            List<Method> methodList = List.of(aClass.getMethods());
            methodList.forEach(aMethod ->{
                if (aMethod.getAnnotation(Handler.class) != null){
                    map.put(aMethod.getAnnotation(Handler.class).request().toString(), aMethod);
                }
            });
        });
        return map;
    }

//    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Map<String, Method> list =  getAllHandler()
//        aMethod.invoke(aClass.getDeclaredConstructor().newInstance());
//    }
}
