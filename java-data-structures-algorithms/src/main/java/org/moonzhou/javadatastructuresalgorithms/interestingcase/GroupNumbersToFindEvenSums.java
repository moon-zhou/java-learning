package org.moonzhou.javadatastructuresalgorithms.interestingcase;

import java.util.ArrayList;
import java.util.List;

public class GroupNumbersToFindEvenSums {
    public static int solution(int[] numbers) {
        // 将每个数字组拆分为单个数字
        List<List<Integer>> groups = new ArrayList<>();
        for (int num : numbers) {
            List<Integer> group = intToDigitList(num);
            // 将 num 拆分为单个数字并添加到 group 中

            groups.add(group);
        }

        return backtrack(groups, 0, 0);
    }

    public static List<Integer> intToDigitList(int num) {
        List<Integer> digitList = new ArrayList<>();

        if (num == 0) {
            digitList.add(0);
            return digitList;
        }

        while (num != 0) {
            digitList.add(num % 10);
            num /= 10;
        }

        // 由于是从低位到高位依次添加到列表的，所以这里反转一下列表，使其变为从高位到低位的顺序
        java.util.Collections.reverse(digitList);

        return digitList;
    }

    private static int backtrack(List<List<Integer>> groups, int index, int currentSum) {
        // 如果已经选择了所有数字组中的数字
        if (index == groups.size()) {
            // 检查当前组合的和是否为偶数
            if (currentSum % 2 == 0) {
                return 1;
            }
            return 0;
        }

        int count = 0;
        // 选择当前数字组中的一个数字
        for (int num : groups.get(index)) {
            // 递归选择下一个数字组中的数字
            count += backtrack(groups, index + 1, currentSum + num);
        }
        return count;
    }

    public static void main(String[] args) {
        // You can add more test cases here
        System.out.println(solution(new int[]{123, 456, 789}) == 14);
        System.out.println(solution(new int[]{123456789}) == 4);
        System.out.println(solution(new int[]{14329, 7568}) == 10);
    }
}