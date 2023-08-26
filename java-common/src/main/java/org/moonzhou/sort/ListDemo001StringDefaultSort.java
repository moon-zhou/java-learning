package org.moonzhou.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author moon zhou
 * @version 1.0
 * @description: list string sort
 *     想要使用该方法进行排序，条件是：集合中的类型T必须是Comparable的子类型， String是Comparable的子类型，所以支持排序。
 *     字符串排序的规则：ascii码从小到大
 *
 *     Comparable：是让一个类具备比较排序的功能
 *     Comparator：自己定义的一个比较器
 * @date 2023/8/26 16:32
 */
public class ListDemo001StringDefaultSort {
    public static void main(String[] args) {
        List<String> sortList1 = initList();

        // 想要使用该方法进行排序，条件是：集合中的类型T必须是Comparable的子类型， String是Comparable的子类型，所以支持排序。
        // 字符串排序的规则：ascii码从小到大
        Collections.sort(sortList1);
        System.out.println(sortList1);
        //[112, 123, 213, 223, 224, Aac, aac, abc]

        System.out.println("-----------------------------------");

        List<String> sortList2 = initList();
        // Collections.sort(sortList2, new Comparator<String>() {
        //             @Override
        //             public int compare(String o1, String o2) {
        //                 return o1.compareTo(o2); // 默认比较方式，与Collections.sort(sortList1);相同
        //             }
        //         });
        sortList2.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2); // 默认比较方式，与Collections.sort(sortList1);相同
            }
        });
        System.out.println(sortList2);
    }

    private static List<String> initList() {
        // 定义一个字符串的list集合,并排序
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("213");
        list.add("abc");
        list.add("aac");
        list.add("112");
        list.add("224");
        list.add("223");
        list.add("Aac");
        System.out.println(list);
        //[123, 213, abc, aac, 112, 224, 223, Aac]
        return list;
    }
}
