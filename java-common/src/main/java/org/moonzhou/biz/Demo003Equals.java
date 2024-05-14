package org.moonzhou.biz;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2024/5/10 15:56
 */
public class Demo003Equals {
    public static boolean areListsEqual(List<String> list1, List<String> list2) {
        Set<String> set1 = new HashSet<>(list1);
        Set<String> set2 = new HashSet<>(list2);
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        List<String> list1 = List.of("apple", "banana", "cherry", "apple");
        List<String> list2 = List.of("banana", "apple", "cherry", "banana");
        List<String> list3 = List.of("apple", "banana");

        System.out.println(areListsEqual(list1, list2)); // true
        System.out.println(areListsEqual(list1, list3)); // false
    }
}
