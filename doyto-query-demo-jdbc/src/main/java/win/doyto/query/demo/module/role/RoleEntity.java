package win.doyto.query.demo.module.role;

import lombok.Getter;
import lombok.Setter;
import win.doyto.query.entity.AbstractPersistable;

/**
 * RoleEntity
 *
 * @author f0rb on 2021-06-21
 */
@Getter
@Setter
public class RoleEntity extends AbstractPersistable<Integer> {
    private String roleName;
    private String roleCode;
    private Boolean valid;
}
