package win.doyto.query.demo.domain.category;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.domain.AbstractPersistable;
import win.doyto.query.demo.domain.item.Item;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * Category
 *
 * @author f0rb on 2022/9/3
 * @since 1.0.0
 */
@Getter
@Setter
@Entity
@EqualsAndHashCode(callSuper = true)
public class Category extends AbstractPersistable<Integer> {

    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.JOIN)
    @JoinTable(
            name = "CATEGORY_ITEM",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )
    protected Set<Item> items = new HashSet<>();

}
