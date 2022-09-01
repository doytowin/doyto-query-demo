package win.doyto.query.demo.domain.bid;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;
import win.doyto.query.demo.domain.item.Item;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bid extends AbstractPersistable<Integer> {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID", nullable = false)
    protected Item item;
}

