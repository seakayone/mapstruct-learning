package org.kleinb.learning.mapstruct.collectionproperties;

import org.mapstruct.Mapper;

@Mapper
public interface ListModelMapper {

  ListModelDto listModelToListModelDto(ListModel model);

  ListModel listModelDtoToListModel(ListModelDto model);
}
