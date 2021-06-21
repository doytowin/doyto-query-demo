package win.doyto.query.demo.module.role;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * RoleControllerTest
 *
 * @author f0rb on 2021-06-21
 */
public class RoleControllerTest {

    @Test
    void createController() {
        RoleController roleController = new RoleController();
        assertNotNull(roleController);
    }
}
