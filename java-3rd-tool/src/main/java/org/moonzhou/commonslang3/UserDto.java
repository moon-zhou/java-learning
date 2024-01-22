package org.moonzhou.commonslang3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2024/1/22 15:13
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserDto {

    private int age;
    private String name;
}
