package org.moonzhou.hutooljackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author moon zhou
 * @version 1.0
 * @description: 使用此方式测试或者使用springboot返回json数据格式测试
 * @date 2023/8/14 21:24
 */
@Slf4j
public class TestDesensitive {

    @Test
    public void test() throws JsonProcessingException {
        TestPojo testPojo = new TestPojo();
        testPojo.setUserName("我是用户名");
        testPojo.setAddress("地球中国-江苏省南京市江宁区");
        testPojo.setPhone("13782946666");
        testPojo.setPassword("sunyangwei123123123.");

        ObjectMapper mapper = new ObjectMapper();
        log.info("test pojo: {}", mapper.writeValueAsString(testPojo));
    }
}
