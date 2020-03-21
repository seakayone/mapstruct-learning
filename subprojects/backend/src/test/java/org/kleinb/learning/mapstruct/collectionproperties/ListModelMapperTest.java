package org.kleinb.learning.mapstruct.collectionproperties;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ListModelMapperTest {

  private ListModelMapper mapper = Mappers.getMapper(ListModelMapper.class);

  @Test
  void collectionModelToCollectionModelDto() {
    final var model = new ListModel();
    model.setListOfStrings(List.of("foo", "bar"));

    final var dto = mapper.listModelToListModelDto(model);

    assertThat(dto.getListOfStrings()).containsExactlyElementsOf(model.getListOfStrings());
  }

  @Test
  void collectionModelDtoToCollectionModel() {
    final var model = ListModelDto.builder().listOfStrings(List.of("foo", "bar")).build();

    final var dto = mapper.listModelDtoToListModel(model);

    assertThat(dto.getListOfStrings()).containsExactlyElementsOf(model.getListOfStrings());
  }
}
