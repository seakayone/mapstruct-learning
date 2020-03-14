/*
 *    Copyright 2020 Christian Kleinbölting
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
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
    final var model = new SimpleModel();
    model.setSomeBoolean(randomBoolean());
    model.setSomeString(randomUuid());
    model.setSomeInt(randomInt());

    final var dto = mapper.simpleModelToSimpleModelDto(model);

    final var softly = new SoftAssertions();
    softly.assertThat(dto.isSomeBoolean()).isEqualTo(model.isSomeBoolean());
    softly.assertThat(dto.getSomeString()).isEqualTo(model.getSomeString());
    softly.assertThat(dto.getSomeInt()).isEqualTo(model.getSomeInt());
    softly.assertAll();
  }

  @Test
  void given_a_dto_then_mapper_maps_all_properties_to_the_model() {
    final var dto = new SimpleModelDto();
    dto.setSomeBoolean(randomBoolean());
    dto.setSomeString(randomUuid());
    dto.setSomeInt(randomInt());

    final var model = mapper.simpleModelDtoToSimpleModel(dto);

    final var softly = new SoftAssertions();
    softly.assertThat(model.isSomeBoolean()).isEqualTo(dto.isSomeBoolean());
    softly.assertThat(model.getSomeString()).isEqualTo(dto.getSomeString());
    softly.assertThat(model.getSomeInt()).isEqualTo(dto.getSomeInt());
    softly.assertAll();
  }

  @Test
  void given_a_model_then_mapper_maps_all_properties_to_the_immutable_dto() {
    final var model = new SimpleModel();
    model.setSomeBoolean(randomBoolean());
    model.setSomeString(randomUuid());
    model.setSomeInt(randomInt());

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
