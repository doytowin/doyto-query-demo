package win.doyto.query.demo.module.role;

import lombok.Getter;
import lombok.Setter;
import win.doyto.query.entity.AbstractPersistable;

import javax.persistence.Table;

/**
 * RoleEntity
 *
 * @author f0rb on 2021-06-21
 */
@Table(name = "t_role")
@Getter
@Setter
public class RoleEntity extends AbstractPersistable<Integer> {
    private String roleName;
    private String roleCode;
    private Boolean valid;
}
