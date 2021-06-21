package win.doyto.query.demo.module.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
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
}
