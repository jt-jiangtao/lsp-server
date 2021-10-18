package com.jiangtao.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jiangtao
 * @Date: 2021/10/18 19:17
 */
public class ClassUtils {
    public static String RootPath = new File("").getAbsolutePath();
    public static String classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

    private static List<Class> getAllClasses(File file, List<Class> classes) throws ClassNotFoundException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) getAllClasses(f, classes);
        } else {
            if (file.getName().endsWith(".class")) {
                String className = file.getPath().replace(".class","").replace(classPath.replace("/","\\").substring(1),"").replace("\\",".");
                classes.add(Class.forName(className));
            }
        }
        return classes;
    }

    public static List<Class> getAllClasses() throws ClassNotFoundException {
        List<Class> list = new ArrayList<>();
        list = getAllClasses(new File(classPath), list);
        return list;
    }

    public static List<Class> getAllClasses(String path) throws ClassNotFoundException {
        List<Class> list = new ArrayList<>();
        list = getAllClasses(new File(path), list);
        return list;
    }
}
