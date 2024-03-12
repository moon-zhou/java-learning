package org.moonzhou.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2024/3/12 17:51
 */
public class Demo002ListStreamMapConvert {

    public static void main(String[] args) {

        testList();

        System.out.println();

        testEmptyList();

        System.out.println();

        testNullList();
    }

    private static void testList() {
        List<ResObj> resObjList = List.of(new ResObj("11", "12"), new ResObj("21", "22"));
        List<TargetObj> targetObjList = resObjList.stream().map(TargetObj::new).collect(Collectors.toList());
        System.out.println(targetObjList);
    }

    /**
     * no exception
     */
    private static void testEmptyList() {
        List<ResObj> resObjList = new ArrayList<>();
        List<TargetObj> targetObjList = resObjList.stream().map(TargetObj::new).collect(Collectors.toList());
        System.out.println(targetObjList);
    }

    /**
     * NPE
     */
    private static void testNullList() {
        try {
            List<ResObj> resObjList = null;
            List<TargetObj> targetObjList = resObjList.stream().map(TargetObj::new).collect(Collectors.toList());
            System.out.println(targetObjList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class ResObj {
        private String field1;
        private String field2;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class TargetObj {
        private String field1;
        private String field2;

        public TargetObj(ResObj resObj) {
            this.field1 = resObj.field1;
            this.field2 = resObj.field2;
        }
    }
}
