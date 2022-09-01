package win.doyto.query.demo.module.user;

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
class UserMvcTest extends DoytoQueryDemoApplicationTests {

    @Test
    void should_query_the_user_list() throws Exception {
        mockMvc.perform(get("/user"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(0))
                .andExpect(jsonPath("$.data.list.size()").value(2))
                .andExpect(jsonPath("$.data.list[0].username").value("admin-1"))
                .andExpect(jsonPath("$.data.list[0].valid").value(true));
    }

    @Test
    void should_query_the_user_list_by_user_name_like() throws Exception {
        mockMvc.perform(get("/user?usernameLike=in-1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(0))
                .andExpect(jsonPath("$.data.list.size()").value(1));
    }

    @Test
    void demo_for_multiple_conditions_query() throws Exception {
        mockMvc.perform(
                       get("/user?account=admin-1&valid=true&perm.permNameLike=list" +
                                   "&mobileNotNull=true&sort=id,desc;create_time,asc" +
                                   "&pageSize=10&pageNumber=5")
               )
               .andDo(print())
               .andExpect(jsonPath("code").value(0))
               .andExpect(jsonPath("$.data.total").value(1));
    }
}
