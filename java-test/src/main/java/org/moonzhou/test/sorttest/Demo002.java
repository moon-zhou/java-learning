package org.moonzhou.test.sorttest;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author moon zhou
 * @version 1.0
 * @description: List stream
 * @date 2023/8/20 21:13
 */
@Slf4j
public class Demo002 {

    public static void main(String[] args) {
        List<Integer> userList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 10000 ; i++) {
            userList.add(rand.nextInt(1000));
        }
        List<Integer> userList2 = new ArrayList<>();
        userList2.addAll(userList);

        Stopwatch stopwatch = Stopwatch.createStarted();
        userList.sort(Comparator.comparing(Integer::intValue));
        log.info("List.sort()耗时：{} ms", stopwatch.elapsed(TimeUnit.MILLISECONDS));

        // 重置并开始
        stopwatch.reset().start();
        userList2.stream().sorted(Comparator.comparing(Integer::intValue)).collect(Collectors.toList());
        log.info("stream.sort耗时：{} ms", stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
