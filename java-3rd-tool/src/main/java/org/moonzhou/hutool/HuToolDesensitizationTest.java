package org.moonzhou.hutool;


import cn.hutool.core.util.DesensitizedUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class HuToolDesensitizationTest {

    @Test
    public void testPhoneDesensitization() {
        String phone = "13723231234";
        String maskPhone = DesensitizedUtil.mobilePhone(phone);
        log.info("testPhoneDesensitization: {}", maskPhone);
        Assert.assertEquals("137****1234", maskPhone);
    }

    @Test
    public void testBankCardDesensitization() {
        String bankCard = "6217000130008255666";
        String maskBankCard = DesensitizedUtil.bankCard(bankCard);
        log.info("testBankCardDesensitization: {}", maskBankCard);
        Assert.assertEquals("6217 **** **** **** 666", maskBankCard);
    }

    @Test
    public void testIdCardNumDesensitization() {
        String idCardNum = "411021199901102321";
        // 只显示前4位和后2位
        String maskIdCardNum = DesensitizedUtil.idCardNum(idCardNum, 4, 2);
        log.info("testIdCardNumDesensitization: {}", maskIdCardNum);
        Assert.assertEquals("4110************21", maskIdCardNum);
    }

    @Test
    public void testPasswordDesensitization() {
        String password = "www.jd.com_35711";
        String maskPassword = DesensitizedUtil.password(password);
        log.info("testIdCardNumDesensitization: {}", maskPassword);
        Assert.assertEquals("****************", maskPassword);
    }
}