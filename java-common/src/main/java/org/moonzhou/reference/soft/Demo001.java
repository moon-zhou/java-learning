package org.moonzhou.reference.soft;

import java.lang.ref.SoftReference;

/**
 *
 * --verbose:gc -Xms20M -Xmx20M -Xmn10M -Xlog:gc* -XX:SurvivorRatio=8
 *
 * @author moon zhou
 * @description
 * @email ayimin1989@163.com
 * @date 2025/6/25 22:06
 **/
public class Demo001 {
    public static void main(String[] args) {
        SoftReference<byte[]> softRef = new SoftReference<>(new byte[10*1024*1024]);
        System.out.println("内存充足时：" + softRef.get()); // 正常获取

        // 强制消耗内存触发GC
        byte[] bigData = new byte[15*1024*1024];
        System.out.println("内存不足时：" + softRef.get()); // 返回null
    }
}
