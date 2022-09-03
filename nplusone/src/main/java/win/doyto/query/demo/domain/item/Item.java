package win.doyto.query.demo.domain.item;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.domain.AbstractPersistable;
import win.doyto.query.demo.domain.bid.Bid;
import win.doyto.query.demo.domain.category.Category;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Getter
@Setter
@Entity
@EqualsAndHashCode(callSuper = true, exclude = {"bids", "bids2"})
public class Item extends AbstractPersistable<Integer> {

    private String name;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private Set<Bid> bids = new HashSet<>();

    @OneToMany(mappedBy = "item")
    @Fetch(FetchMode.SUBSELECT)
    private Set<Bid> bids2 = new HashSet<>();

    @ManyToMany(mappedBy = "items")
    @Fetch(FetchMode.SUBSELECT)
    private List<Category> categories;
}