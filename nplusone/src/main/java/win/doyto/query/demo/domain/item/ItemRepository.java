package win.doyto.query.demo.domain.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ItemRepository
 *
 * @author f0rb on 2022/9/1
 * @since 1.0.0
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
