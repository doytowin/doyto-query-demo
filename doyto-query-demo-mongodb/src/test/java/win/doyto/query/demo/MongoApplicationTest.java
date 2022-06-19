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

package win.doyto.query.demo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import lombok.SneakyThrows;
import org.bson.BsonArray;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.StreamUtils;

import java.nio.charset.Charset;
import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * MongoApplicationTest
 *
 * @author f0rb on 2022-01-25
 */
@ActiveProfiles("test")
@AutoConfigureMockMvc
//@AutoConfigureDataMongo
@SpringBootTest(properties = {"spring.mongodb.embedded.version=5.0.5"})
//@DataMongoTest(properties = {"spring.mongodb.embedded.version=5.0.5"})
@WebAppConfiguration
public abstract class MongoApplicationTest {
    @Resource
    protected MockMvc mockMvc;

    @SneakyThrows
    private static String readString(String path) {
        return StreamUtils.copyToString(MongoApplicationTest.class.getResourceAsStream(path), Charset.defaultCharset());
    }

    @BeforeAll
    static void beforeAll(@Autowired MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("doyto");
        String text = readString("/data.json");
        BsonArray bsonValues = BsonArray.parse(text);
        bsonValues.forEach(bsonValue -> database.runCommand(bsonValue.asDocument()));
    }

    protected ResultActions performAndExpectSuccess(RequestBuilder requestBuilder) throws Exception {
        return mockMvc.perform(requestBuilder)
                      //.andDo(print())
                      .andExpect(status().isOk())
                      .andExpect(jsonPath("$.success").value(true));
    }

}
