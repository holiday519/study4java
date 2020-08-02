package com.ee.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> clazz = null;
        String myClass = "/Users/zhengyi/Desktop/pkg/" + name + ".class";
        File classFile = new File(myClass);
        if (classFile.exists()) {
            try (FileChannel fileChannel = new FileInputStream(classFile).getChannel()) {
                ByteBuffer byteBuffer = ByteBuffer.allocate((int) fileChannel.size());
                while ((fileChannel.read(byteBuffer)) > 0) {
                }
                byte[] b = byteBuffer.array();

                clazz = defineClass(name, b, 0, b.length);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return clazz;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException {
        MyClassLoader loader = new MyClassLoader();
        Class<?> example = loader.loadClass("Example");
        Method sayHello = example.getDeclaredMethod("sayHello");
        sayHello.invoke(example.newInstance());
    }
}
