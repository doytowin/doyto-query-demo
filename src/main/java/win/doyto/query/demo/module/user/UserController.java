package win.doyto.query.demo.module.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.doyto.query.web.controller.AbstractIQEEController;

/**
 * @author Simon
 * @date 2021/6/21 21:41
 */
@RestController
@RequestMapping("user")
public class UserController extends AbstractIQEEController<UserEntity, Integer, UserQuery> {
}
