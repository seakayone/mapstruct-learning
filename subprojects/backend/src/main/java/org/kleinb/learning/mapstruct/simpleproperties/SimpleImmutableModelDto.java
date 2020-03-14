package org.kleinb.learning.mapstruct.simpleproperties;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SimpleImmutableModelDto {

  String someString;
  int someInt;
  boolean someBoolean;
}
