package org.kleinb.learning.mapstruct.collectionproperties;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class VavrMapperTest {

  private final VavrMapper mapper = Mappers.getMapper(VavrMapper.class);

  @Test
  void java_String_list_property_is_transformed_to_vavr_String_list() {
    final var model = new ListModel();
    model.setListOfStrings(List.of("42"));

    final var actual = mapper.listModelToVavrListModelDto(model);
    assertThat(actual.getListOfStrings()).containsExactlyElementsOf(model.getListOfStrings());
  }

  @Test
  void vavr_String_list_property_is_transformed_to_java_String_list() {
    final var model = VavrListModel.builder()
        .listOfStrings(io.vavr.collection.List.of("4711"))
        .build();

    final var actual = mapper.vavrListModelToListModelDto(model);
    assertThat(actual.getListOfStrings()).containsExactlyElementsOf(model.getListOfStrings());
  }
}

