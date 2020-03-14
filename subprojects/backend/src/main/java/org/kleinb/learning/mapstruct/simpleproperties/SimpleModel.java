package org.kleinb.learning.mapstruct.simpleproperties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PACKAGE)
public class SimpleModel {

  private String someString;
  private int someInt;
  private boolean someBoolean;
}

