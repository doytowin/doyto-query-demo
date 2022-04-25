package win.doyto.query.demo.module.role;

import org.junit.jupiter.api.Test;
import win.doyto.query.demo.DoytoQueryDemoApplicationTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Simon
 * @date 2021/6/21 20:35
 */
class RoleMvcTest extends DoytoQueryDemoApplicationTests {

    @Test
    void should_query_the_role_list() throws Exception {
        mockMvc.perform(get("/role"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(0))
                .andExpect(jsonPath("$.data.list.size()").value(5));
    }

    @Test
    void should_query_the_role_list_by_role_name_like() throws Exception {
        mockMvc.perform(get("/role?roleNameLike=vip"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(0))
                .andExpect(jsonPath("$.data.list.size()").value(3));
    }
}
