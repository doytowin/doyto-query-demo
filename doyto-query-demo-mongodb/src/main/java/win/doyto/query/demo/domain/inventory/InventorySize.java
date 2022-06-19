/*
 * Copyright © 2019-2022 Forb Yuan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package win.doyto.query.demo.domain.inventory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import win.doyto.query.mongodb.entity.MongoPersistable;

/**
 * SizeEntity
 *
 * @author f0rb on 2021-11-23
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventorySize extends MongoPersistable<ObjectId> {
    private Double h;
    private Double w;
    private String uom;
}
