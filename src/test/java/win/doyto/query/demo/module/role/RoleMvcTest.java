package win.doyto.query.demo.module.role;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import win.doyto.query.demo.DoytoQueryDemoApplicationTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Simon
 * @date 2021/6/21 20:35
 */
public class RoleMvcTest extends DoytoQueryDemoApplicationTests {

    @Test
    void should_query_the_role_list() throws Exception {
        mockMvc.perform(
                get("/role")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(
                        header().stringValues(
                                "Content-Type", MediaType.APPLICATION_JSON_VALUE
                        )
                )
                .andExpect(jsonPath("code").value(0))
                .andExpect(jsonPath("$.data.list.size()").value(5));
    }
}