package org.moonzhou.feature.record.demo002define;

/**
 * record作为单独文件的顶级类
 * @author moon zhou
 * @param id
 * @param name
 * @param age
 */
public record UserRecord(long id, String name, int age) {}
