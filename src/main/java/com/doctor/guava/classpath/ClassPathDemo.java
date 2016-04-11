package com.doctor.guava.classpath;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

/**
 * @author sdcuike
 *
 *         Create At 2016年4月11日 下午4:50:47
 */
public class ClassPathDemo {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        URL resource = ClassPathDemo.class.getClassLoader().getResource("");
        URL url2 = new URL("file://" + resource.getFile() + "test");
        System.out.println(url2);
        URL[] urls = new URL[] { url2 };
        ClassLoader classloader = new URLClassLoader(urls);
        ClassPath classPath = ClassPath.from(classloader);
        ImmutableSet<ClassInfo> allClasses = classPath.getAllClasses();
        try {
            allClasses.stream().map((ClassInfo::load)).forEach(System.out::println);
        } catch (Throwable e) {
        }

    }

}
