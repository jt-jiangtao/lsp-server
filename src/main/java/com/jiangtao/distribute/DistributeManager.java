package com.jiangtao.distribute;

import com.jiangtao.utils.AnnotationUtils;
import io.netty.channel.Channel;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: jiangtao
 * @Date: 2021/10/18 18:45
 */
public class DistributeManager {
    private static Map<String, Method> map = new ConcurrentHashMap<String, Method>();

    public static Method getProcessor(String requestMethod){
        return map.get(requestMethod);
    }

    public static Map<String, Method> getMap() {
        return map;
    }

    public static void setMap(Map<String, Method> map) {
        DistributeManager.map = map;
    }

    public static int scanner() throws ClassNotFoundException {
        map = AnnotationUtils.getAllHandler();
        return map.size();
    }
}
