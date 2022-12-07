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

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.StreamUtils;
import win.doyto.query.demo.DoytoQueryDemoApplication;

import java.io.InputStream;
import java.nio.charset.Charset;
import javax.annotation.Resource;

import static org.hamcrest.Matchers.containsInRelativeOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * InventoryMvcTest
 *
 * @author f0rb on 2021-12-08
 */
@AutoConfigureMockMvc
@SpringBootTest(properties = {"spring.mongodb.embedded.version=5.0.5"})
class InventoryMvcTest {
    @Resource
    protected MockMvc mockMvc;

    @BeforeAll
    static void beforeAll(@Autowired MockMvc mockMvc) throws Exception {
        InputStream is = DoytoQueryDemoApplication.class.getResourceAsStream("/inventory.json");
        String data = StreamUtils.copyToString(is, Charset.defaultCharset());
        mockMvc.perform(post("/inventory/").content(data).contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void queryExamples() throws Exception {
        mockMvc.perform(get("/inventory/?itemContain=book"))
               .andExpect(jsonPath("$.data.total").value(1));

        mockMvc.perform(get("/inventory/?status=A"))
               .andExpect(jsonPath("$.data.total").value(3));

        mockMvc.perform(get("/inventory/?size.hLt=12&status=A"))
               .andExpect(jsonPath("$.data.total").value(2))
               .andExpect(jsonPath("$.data.list[*].item",
                                   containsInRelativeOrder("notebook", "postcard")));

        mockMvc.perform(get("/inventory/?size.uom=in"))
               .andExpect(jsonPath("$.data.total").value(2))
               .andExpect(jsonPath("$.data.list[*].item",
                                   containsInRelativeOrder("notebook", "paper")));
    }
}
