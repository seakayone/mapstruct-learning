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
