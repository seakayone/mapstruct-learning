package org.kleinb.learning.mapstruct.collectionproperties;

import io.vavr.collection.List;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class VavrListModel {

  List<String> listOfStrings;

}
