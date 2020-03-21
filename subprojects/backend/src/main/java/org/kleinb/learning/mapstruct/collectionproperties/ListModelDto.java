package org.kleinb.learning.mapstruct.collectionproperties;

import java.util.List;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ListModelDto {

  List<String> listOfStrings;
}
