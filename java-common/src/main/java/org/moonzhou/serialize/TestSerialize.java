package org.moonzhou.serialize;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author moon zhou
 * @version 1.0
 * @description: junit test serialize
 * @date 2023/8/16 21:17
 */
@Slf4j
public class TestSerialize {

    @Test
    public void initSerializeFile() {
        // SerialClass: no serialVersionUID
        // SerialClass: 1L serialVersionUID
        // SerialClass: random generate serialVersionUID: -8192434815983218168L
        SerialClass moonzhou = new SerialClass("moon zhou", "001", 18, 75.0);



    }

    @Test
    public void testSerialize() {
        SerialClass moonzhou = new SerialClass("moon zhou", "001", 18, 75.0);

        byte[] serializer = Serializer.Algorithm.java.serializer(moonzhou);
        SerialClass serialClass = Serializer.Algorithm.java.deSerializer(serializer, SerialClass.class);
        log.info("testSerialize deSerializer: {}", serialClass);

        Assert.assertNotNull(serialClass);
        Assert.assertEquals(moonzhou.getName(), serialClass.getName());
        Assert.assertEquals(moonzhou.getId(), serialClass.getId());
        Assert.assertEquals(moonzhou.getAge(), serialClass.getAge());
        Assert.assertNotEquals(moonzhou.getWeight(), serialClass.getWeight());
        Assert.assertEquals(0.0, serialClass.getWeight(), 0);
    }

    @Test
    public void testSerializeSame() {
        SerialClass moonzhou = new SerialClass("moon zhou", "001", 18, 75.0);

        byte[] serializer = Serializer.Algorithm.java.serializer(moonzhou);

        // exception
        // java.lang.ClassCastException: class org.moonzhou.serialize.SerialClass cannot be cast to class org.moonzhou.serialize.SerialClassSame
        // (org.moonzhou.serialize.SerialClass and org.moonzhou.serialize.SerialClassSame are in unnamed module of loader 'app')
        SerialClassSame serialClass = Serializer.Algorithm.java.deSerializer(serializer, SerialClassSame.class);

    }

}
