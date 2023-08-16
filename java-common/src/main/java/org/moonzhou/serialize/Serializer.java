package org.moonzhou.serialize;

import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 为了支持更多的序列化方法
 */
public interface Serializer {

    /**
     * 反序列化
     * 将byte[]或json 转换为 java对象
     *
     * @param bytes 字节数组
     * @param clazz 要转换成的java对象类型
     * @param <T>   泛型
     * @return
     */
    <T> T deSerializer(byte[] bytes, Class<T> clazz);


    /**
     * 序列化
     * 将java对象 转换为 byte[]或json类型
     */
    <T> byte[] serializer(T object);

    /**
     * 序列化
     * 将实例对象序列化到文件
     * @param object
     * @param <T>
     */
    <T> void serializerFile(T object) throws IOException;


    /**
     * 反序列化
     * 将文件里的序列化值反序列化为实例对象
     * @param inputStream
     * @param clazz
     * @return
     * @param <T>
     */
    <T> T deSerializerFile(InputStream inputStream, Class<T> clazz);


    /**
     * 创建内部枚举类 Algorithm，实现序列化
     */
    enum Algorithm implements Serializer {

        // java代表是自带jdk的序列化与反序列化
        java {
            @Override
            public <T> T deSerializer(byte[] bytes, Class<T> clazz) {
                try {
                    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
                    // 对象输出流读取java对象
                    return (T) ois.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                    throw new RuntimeException("反序列化失败", e);
                }
            }

            @Override
            public <T> byte[] serializer(T object) {
                try {
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(bos);
                    // 将java对象写入到对象输出流中
                    oos.writeObject(object);
                    byte[] bytes = bos.toByteArray(); // 返回字节数组
                    return bytes;
                } catch (IOException e) {
                    throw new RuntimeException("序列化失败", e);
                }
            }

            @Override
            public <T> void serializerFile(T object) throws IOException {
                // 当前执行的
                // ObjectOutputStream out = new ObjectOutputStream(new FileInputStream("serial.ser"));
                // out.writeObject(object);
                // out.close();
            }

            @Override
            public <T> T deSerializerFile(InputStream inputStream, Class<T> clazz) {
                return null;
            }
        },

        json {
            @Override
            public <T> T deSerializer(byte[] bytes, Class<T> clazz) {
                // 将字节数组转换为字符串
                String json = new String(bytes, StandardCharsets.UTF_8);
                return new Gson().fromJson(json, clazz);
            }

            @Override
            public <T> byte[] serializer(T object) {
                Gson gson = new Gson();
                // 将java对象转化为json字符串
                String json = gson.toJson(object);
                // 将json字符串转换为字节数组
                return json.getBytes(StandardCharsets.UTF_8);
            }

            @Override
            public <T> void serializerFile(T object) {

            }

            @Override
            public <T> T deSerializerFile(InputStream inputStream, Class<T> clazz) {
                return null;
            }
        }
    }
}

