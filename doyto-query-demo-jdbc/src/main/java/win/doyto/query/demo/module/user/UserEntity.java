package win.doyto.query.demo.module.user;

import lombok.Getter;
import lombok.Setter;
import win.doyto.query.entity.AbstractPersistable;

/**
 * @author Simon
 * @date 2021/6/21 21:42
 */
@Getter
@Setter
public class UserEntity extends AbstractPersistable<Integer> {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private Boolean valid;
}
