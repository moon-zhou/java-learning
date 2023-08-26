package org.moonzhou.sort;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author moon zhou
 * @version 1.0
 * @description: list object sort
 *
 * Comparable：是让一个类具备比较排序的功能
 * Comparator：自己定义的一个比较器
 *
 * @date 2023/8/26 16:37
 */
public class ListDemo003ObjectFieldSort {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("moon1", 28, 90.5));
        list.add(new Student("moon2", 20, 90.6));
        list.add(new Student("moon3", 18, 80.0));
        list.add(new Student("moon", 18, 100.0));

        Collections.sort(list);
        System.out.println(list);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Student implements Comparable<Student> {
        private String name;
        private Integer age;
        private Double score;

        @Override
        public int compareTo(Student o) {
            // score 升序，与Double.compareTo一致
            // if (this.score > o.score) {
            //     return 1;
            // } else if (this.score < o.score) {
            //     return -1;
            // } else {
            //     return 0;
            // }
            return this.score.compareTo(o.score); // score 升序
            // return this.age - o.age; // age 升序
        }
    }
}
