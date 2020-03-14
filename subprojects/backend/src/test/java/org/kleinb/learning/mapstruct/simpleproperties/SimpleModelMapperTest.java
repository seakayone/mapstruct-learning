package org.kleinb.learning.mapstruct.simpleproperties;

import static org.kleinb.learning.mapstruct.testsupport.RandomTestData.randomBoolean;
import static org.kleinb.learning.mapstruct.testsupport.RandomTestData.randomInt;
import static org.kleinb.learning.mapstruct.testsupport.RandomTestData.randomUuid;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SimpleModelMapperTest {

  private final SimpleModelMapper mapper = Mappers.getMapper(SimpleModelMapper.class);

  @Test
  void given_a_model_then_mapper_maps_all_properties_to_the_dto() {
    final var model = SimpleModel.builder()
        .someBoolean(randomBoolean())
        .someString(randomUuid())
        .someInt(randomInt())
        .build();

    final var dto = mapper.simpleModelToSimpleModelDto(model);

    final var softly = new SoftAssertions();
    softly.assertThat(dto.isSomeBoolean()).isEqualTo(model.isSomeBoolean());
    softly.assertThat(dto.getSomeString()).isEqualTo(model.getSomeString());
    softly.assertThat(dto.getSomeInt()).isEqualTo(model.getSomeInt());
    softly.assertAll();
  }

  @Test
  void given_a_dto_then_mapper_maps_all_properties_to_the_model() {
    final var dto = SimpleModelDto.builder()
        .someBoolean(randomBoolean())
        .someString(randomUuid())
        .someInt(randomInt())
        .build();

    final var model = mapper.simpleModelDtoToSimpleModel(dto);

    final var softly = new SoftAssertions();
    softly.assertThat(model.isSomeBoolean()).isEqualTo(dto.isSomeBoolean());
    softly.assertThat(model.getSomeString()).isEqualTo(dto.getSomeString());
    softly.assertThat(model.getSomeInt()).isEqualTo(dto.getSomeInt());
    softly.assertAll();
  }

  @Test
  void given_a_model_then_mapper_maps_all_properties_to_the_immutable_dto() {
    final var model = SimpleModel.builder()
        .someBoolean(randomBoolean())
        .someString(randomUuid())
        .someInt(randomInt())
        .build();

    final var dto = mapper.simpleModelToSimpleImmutableModelDto(model);

    final var softly = new SoftAssertions();
    softly.assertThat(dto.isSomeBoolean()).isEqualTo(model.isSomeBoolean());
    softly.assertThat(dto.getSomeString()).isEqualTo(model.getSomeString());
    softly.assertThat(dto.getSomeInt()).isEqualTo(model.getSomeInt());
    softly.assertAll();
  }

  @Test
  void given_an_immutable_dto_then_mapper_maps_all_properties_to_the_model() {
    final var dto = SimpleImmutableModelDto.builder()
        .someBoolean(randomBoolean())
        .someString(randomUuid())
        .someInt(randomInt())
        .build();

    final var model = mapper.simpleImmutableModelDtoToSimpleModel(dto);

    final var softly = new SoftAssertions();
    softly.assertThat(model.isSomeBoolean()).isEqualTo(dto.isSomeBoolean());
    softly.assertThat(model.getSomeString()).isEqualTo(dto.getSomeString());
    softly.assertThat(model.getSomeInt()).isEqualTo(dto.getSomeInt());
    softly.assertAll();
  }
}
