package org.moonzhou.biz;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2024/11/29 15:11
 */
public class Demo008DynamicParam {
    public static void main(String[] args) {
        Demo008DynamicParam test = new Demo008DynamicParam();
        System.out.println(test.concatParam("aaa", "bbb", "ccc"));
        System.out.println(test.concatParam("aaa"));
    }

    private String concatParam(String... params) {
        // 使用 "-" 拼接参数 params
        return String.join("-", params);
    }

    private String concatParam(String param) {
        return param;
    }
}
