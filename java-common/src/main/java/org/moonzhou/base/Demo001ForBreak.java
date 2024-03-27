package org.moonzhou.base;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2024/3/26 16:23
 */
public class Demo001ForBreak {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("i: " + i + ", j: " + j);

                // This is where you can put the logic to determine when to break out of all loops
                if (i == 3 && j == 1) {
                    System.out.println("break");
                    // break; // Break out of both loops
                    return;
                }
            }
        }
    }
}
