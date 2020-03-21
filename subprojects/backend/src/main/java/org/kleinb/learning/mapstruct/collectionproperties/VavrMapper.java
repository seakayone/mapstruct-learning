package org.kleinb.learning.mapstruct.collectionproperties;

import org.mapstruct.Mapper;

@Mapper
public interface VavrMapper {

  VavrListModel listModelToVavrListModelDto(ListModel model);

  default io.vavr.collection.List<String> toVavrList(java.util.List<String> jList) {
    return io.vavr.collection.List.ofAll(jList);
  }

  ListModel vavrListModelToListModelDto(VavrListModel model);

  default java.util.List<String> toJavaList(io.vavr.collection.List<String> vList) {
    return vList.toJavaList();
  }
}
