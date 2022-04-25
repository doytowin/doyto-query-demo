package win.doyto.query.demo.module.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Simon
 * @date 2021/6/21 21:39
 */
class UserControllerTest {
    @Test
    void create_user_controller() {
        UserController userController = new UserController();
        assertNotNull(userController);
    }
}
