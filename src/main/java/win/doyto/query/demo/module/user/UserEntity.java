package win.doyto.query.demo.module.user;

import lombok.Getter;
import lombok.Setter;
import win.doyto.query.entity.IntegerId;

import javax.persistence.Table;

/**
 * @author Simon
 * @date 2021/6/21 21:42
 */
@Table(name = "t_user")
@Getter
@Setter
public class UserEntity extends IntegerId {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private Boolean valid;
}
