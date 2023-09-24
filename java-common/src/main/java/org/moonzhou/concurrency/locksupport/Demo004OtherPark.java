package org.moonzhou.concurrency.locksupport;

import com.google.common.base.Stopwatch;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.TemporalField;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/9/24 16:17
 */
public class Demo004OtherPark {

    public static void main(String[] args) {
        // testParkNanos();
        testParkUntil();
    }

    private static void testParkNanos() {
        System.out.println("begin park");

        Stopwatch stopwatch = Stopwatch.createStarted();

        LockSupport.parkNanos(2000000000L); // 1ms=10^6ns  设置时长2000ms 2s后自动返回

        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));

        System.out.println("end park");
    }

    private static void testParkUntil() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime after5seconds = now.plusSeconds(5);

        System.out.println("begin park: " + LocalDateTime.now());
        LockSupport.parkUntil(Timestamp.valueOf(after5seconds).getTime());//当前时间再过5s阻塞结束
        System.out.println("end park: " + LocalDateTime.now());
    }
}
