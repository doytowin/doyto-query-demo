package win.doyto.query.demo.module.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import win.doyto.query.annotation.NestedQueries;
import win.doyto.query.annotation.NestedQuery;
import win.doyto.query.core.PageQuery;

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
    @NestedQueries({
            @NestedQuery(select = "user_id", from = "t_user_and_role"),
            @NestedQuery(select = "role_id", from = "t_role_and_perm", where = "perm_id"),
            @NestedQuery(select = "id", from = "t_perm")
    })
    private String permNameLike;

    public void setAccount(String account) {
        this.accountOr = AccountOr.builder().username(account).email(account).mobile(account).build();
    }
}
