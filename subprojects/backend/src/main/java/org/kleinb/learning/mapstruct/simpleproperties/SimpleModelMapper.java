package org.kleinb.learning.mapstruct.simpleproperties;

import org.mapstruct.Mapper;

@Mapper
public interface SimpleModelMapper {

  SimpleModel simpleModelDtoToSimpleModel(SimpleModelDto dto);

  SimpleModelDto simpleModelToSimpleModelDto(SimpleModel model);
}
