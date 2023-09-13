package org.moonzhou.jvm.stack;

import com.google.common.base.Stopwatch;
import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * Java对象分配过程：
 * 1. 尝试在栈上分配，成功，则在栈上分配（栈上分配是jvm的优化技术，将线程私有对象打散分配在栈上，对象回收直接POP出栈，无需gc介入，效率高）
 *    - 栈空间小，对于大对象无法实现栈上分配
 *    - 对象不能出现逃逸(JVM参数：-XX:+DoEscapeAnalysis)
 *    - 对象可进行表量替换，即使用字段来表示对象（-XX:+EliminateAllocations），即可以使用age和username来代替User对象
 * 2. 栈上分配失败，尝试在TLAB上分配，成功，则在TLAB上分配（Thread Local Allocation Buffer，线程本地分配缓存，线程专用的内存分配区域，占用的是eden区的空间。默认开启，JVM会为每个线程分配一块TLAB区域）
 * 3. TLAB上分配失败，是否可进入老年代，成功，则分配到老年代
 * 4. 老年代分配失败，分配在eden区
 *
 * 在使用打印的时候导致了 user 对象的逃逸，所以导致在栈上分配条件不满足，只能在堆上分配，这样就会导致频繁的 GC
 * idea打印gc（放开输出之后，可以明确看到在频繁gc）：-XX:+PrintGC  或者 -Xlog:gc
 * -XX:+PrintGC is deprecated. Will use -Xlog:gc instead
 *
 * -verbose:gc
 * -XX:+PrintGCDetails
 *
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/9/13 09:16
 */
public class Demo001ObjectStackAllocation {

    public static void main(String[] args) {
        Stopwatch stopwatch = Stopwatch.createStarted();

        User user = null;
        for (int i = 0; i < 1000000000; i++) {
            user = new User();
        }
        // jdk 17 不加打印 3ms，加打印3706ms
        // System.out.println有锁，单线程锁消除
        System.out.println(user);
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    @Data
    static class User {
        private int age;
        private String userName;
    }

}
