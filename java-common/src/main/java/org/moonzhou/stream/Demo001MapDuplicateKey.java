package org.moonzhou.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/11/28 10:31
 */
@Slf4j
public class Demo001MapDuplicateKey {
    public static void main(String[] args) {

        List<BizObject> distinctList = List.of(new BizObject("1", "111"), new BizObject("3", "333"));
        System.out.println(distinctList);

        Map<String, String> distinctMap = distinctList.stream().collect(Collectors.toMap(BizObject::getKey, BizObject::getValue));
        System.out.println(distinctMap);


        List<BizObject> duplicateList = List.of(new BizObject("1", "111"), new BizObject("3", "333"),
                new BizObject("1", "222"), new BizObject("1", "333"), new BizObject("1", "666"));
        System.out.println(duplicateList);

        try {
            // java.lang.IllegalStateException: Duplicate key
            Map<String, String> exceptionMap = duplicateList.stream().collect(Collectors.toMap(BizObject::getKey, BizObject::getValue));
            System.out.println(exceptionMap);
        } catch (Exception e) {
            log.error("error", e);
        }

        // Map<String, String> newMap = duplicateList.stream().collect(Collectors.toMap(BizObject::getKey, BizObject::getValue, (existingValue, newValue) -> existingValue));
        Map<String, String> newMap = duplicateList.stream().collect(Collectors.toMap(BizObject::getKey, BizObject::getValue, (existingValue, newValue) -> newValue));
        System.out.println(newMap);
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    static class BizObject {
        private String key;
        private String value;
    }
}
