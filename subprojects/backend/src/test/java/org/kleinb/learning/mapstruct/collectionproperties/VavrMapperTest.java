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

