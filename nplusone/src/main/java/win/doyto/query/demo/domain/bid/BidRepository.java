package win.doyto.query.demo.domain.bid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BidRepository
 *
 * @author f0rb on 2022/9/1
 * @since 1.0.0
 */
@Repository
public interface BidRepository extends JpaRepository<Bid, Integer> {
}
