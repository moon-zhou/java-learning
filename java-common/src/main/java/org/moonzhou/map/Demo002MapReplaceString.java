package org.moonzhou.map;

import org.apache.commons.lang3.text.StrSubstitutor;
import org.apache.commons.text.StringSubstitutor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author moon zhou
 * @description
 * @email
 * @date 2025/8/12 17:52
 **/
public class Demo002MapReplaceString {
    public static void main(String[] args) {
        Map<String, Object> valuesMap = createValuesMap();
        
        // 原有的实现方法（已过时）
        String result1 = replaceByStrSubstitutor(valuesMap);
        System.out.println("使用 StrSubstitutor 替换后的字符串: " + result1);
        
        // 新的替代方案
        String result2 = replaceByStringSubstitutor(valuesMap);
        System.out.println("使用 StringSubstitutor 替换后的字符串: " + result2);

    }

    private static Map<String, Object> createValuesMap() {
        Map<String, Object> valuesMap = new HashMap<>();
        valuesMap.put("name", "Moon Zhou");
        valuesMap.put("age", 30);
        valuesMap.put("city", "Shanghai");
        return valuesMap;
    }

    /**
     * 原始实现方法，使用已过时的 StrSubstitutor 类
     * @param valuesMap 替换值映射
     * @return 替换后的字符串
     */
    private static String replaceByStrSubstitutor(Map<String, Object> valuesMap) {
        String template = "Name: ${name}, Age: ${age}, City: ${city}";
        StrSubstitutor substitutor = new StrSubstitutor(valuesMap);
        return substitutor.replace(template);
    }
    
    /**
     * 新的替代方案，使用推荐的 StringSubstitutor 类
     * @param valuesMap 替换值映射
     * @return 替换后的字符串
     */
    private static String replaceByStringSubstitutor(Map<String, Object> valuesMap) {
        String template = "Name: ${name}, Age: ${age}, City: ${city}";
        StringSubstitutor substitutor = new StringSubstitutor(valuesMap);
        return substitutor.replace(template);
    }

}