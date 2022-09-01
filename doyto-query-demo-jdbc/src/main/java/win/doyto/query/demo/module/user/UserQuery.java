package win.doyto.query.demo.module.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import win.doyto.query.annotation.DomainPath;
import win.doyto.query.core.PageQuery;
import win.doyto.query.demo.module.perm.PermQuery;

/**
 * @author Simon
 * @date 2021/6/21 21:42
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserQuery extends PageQuery {
    private Integer id;
    private String usernameLike;
    private AccountOr accountOr;
    private Boolean valid;
    private boolean mobileNotNull;

    @DomainPath({"user", "role", "perm"})
    private PermQuery perm;

    public void setAccount(String account) {
        this.accountOr = AccountOr.builder().username(account).email(account).mobile(account).build();
    }
}
