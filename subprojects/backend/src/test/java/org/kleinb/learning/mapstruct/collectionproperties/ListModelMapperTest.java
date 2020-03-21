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
