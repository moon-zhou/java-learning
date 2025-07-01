package org.moonzhou.reference.soft;

import lombok.Getter;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * @author moon zhou
 * @description
 * @email ayimin1989@163.com
 * @date 2025/7/1 23:20
 **/
public class Demo002 {

    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        SoftReference<MyObject> softReference = new SoftReference<>(myObject);//软引用
        //内存够用
        System.out.println("Gc前：" + softReference.get());
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Gc后内存够用：" + softReference.get());

        //设置参数-Xms10m -Xmx10m , 内存不够用
        byte[] bytes = new byte[8 * 1024 * 1024];
        System.out.println("Gc后内存不够用：" + softReference.get()); // TODO java17，G1 OOM 执行不到此处，需要再分析
    }

    @Getter
    static class MyObject {
        byte[] bytes = new byte[10 * 1024 * 1024];

        public MyObject() {
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("对象被回收了, finalize()"); // 此处会执行
        }
    }
}
