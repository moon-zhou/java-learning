package org.moonzhou.serialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/8/16 20:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SerialClassSame implements Serializable {

    private String name;

    private String id;

    private int age;

    /**
     * transient: ignore Serializable
     */
    private transient double weight;
}
