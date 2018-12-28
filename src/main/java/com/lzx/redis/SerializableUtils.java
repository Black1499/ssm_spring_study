package com.lzx.redis;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class SerializableUtils {

    /**
     * 序列化,List
     */
    public static <T> void writeObject(List<T> list, File file) throws IOException {
        T[] array = (T[]) list.toArray();
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        outputStream.writeObject(array);
        outputStream.flush();
        outputStream.close();
    }

    /**
     * 反序列化,List
     */
    public static <T> List<T> readObjectForList(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        T[] object = (T[]) inputStream.readObject();
        inputStream.close();
        return Arrays.asList(object);
    }
}
