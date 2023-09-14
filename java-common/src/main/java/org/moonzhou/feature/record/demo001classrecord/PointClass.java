package org.moonzhou.feature.record.demo001classrecord;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author moon zhou
 */
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class PointClass {
  private final int x;
  private final int y;
}