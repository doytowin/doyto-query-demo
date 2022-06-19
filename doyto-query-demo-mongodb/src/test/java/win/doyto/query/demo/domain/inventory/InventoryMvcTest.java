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

import org.junit.jupiter.api.Test;
import win.doyto.query.demo.MongoApplicationTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * InventoryMvcTest
 *
 * @author f0rb on 2021-12-08
 */
class InventoryMvcTest extends MongoApplicationTest {
    @Test
    void query() throws Exception {
        performAndExpectSuccess(get("/inventory?size.hGt=10"))
                .andDo(print())
                .andExpect(jsonPath("code").value(0))
                .andExpect(jsonPath("$.data.total").value(2));
    }
}
