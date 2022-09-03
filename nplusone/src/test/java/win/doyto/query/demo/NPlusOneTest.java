package win.doyto.query.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import win.doyto.query.demo.domain.bid.Bid;
import win.doyto.query.demo.domain.bid.BidRepository;
import win.doyto.query.demo.domain.category.Category;
import win.doyto.query.demo.domain.item.Item;
import win.doyto.query.demo.domain.item.ItemRepository;

import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * NPlusOneTest
 *
 * @author f0rb on 2022/9/1
 * @since 1.0.0
 */
@ActiveProfiles("test")
@Transactional
@SpringBootTest
class NPlusOneTest {

    @Resource
    private ItemRepository itemRepository;
    @Resource
    private BidRepository bidRepository;

    @Resource
    private EntityManager em;

    //@Transactional
    @BeforeAll
    static synchronized void beforeAll(@Autowired EntityManager em, @Autowired ItemRepository itemRepository) {
        //if (initialized) return;


        Item item;
        item = buildItem("Book");
        itemRepository.save(item);

        item = buildItem("Paper");
        itemRepository.save(item);

        item = buildItem("Pen");
        itemRepository.save(item);
        //em.persist(item);

        //Bid bidEntity;

        //bidEntity = new Bid();

        //bidEntity.setItem(item);
        //em.persist(bidEntity);
        //
        //bidEntity = new Bid();
        //bidEntity.setItem(item);
        //em.persist(bidEntity);

        //initialized = true;
    }

    private static Item buildItem(String name) {
        Item item = new Item();
        item.setName(name);
        Set<Bid> bidEntities = item.getBids();
        bidEntities.add(new Bid(item));
        bidEntities.add(new Bid(item));
        return item;
    }

    @SuppressWarnings("unchecked")
    @Test
    void nPlusOneProblem() {
        List<Bid> bids = em.createQuery("select b from Bid b").getResultList();
        // select * from BID
        for (Bid bid : bids) {
            assertNotNull(bid.getItem().getName());
            // select * from ITEM where ID = ?
        }
    }

    @Test
    void lazyFind() {
        List<Bid> bids = bidRepository.findAll();
        System.out.println("Size of bids:" + bids.size());

        for (Bid bid : bids) {
            Item item = bid.getItem();
            assertNotNull(item.getName());
            //System.out.printf("%d:%s\n", item.getId(), item.getName());
        }
    }

    @Test
    void testSubSelectSolutionForNPlusOne() {
        List<Item> items = itemRepository.findAll();
        System.out.println("Size of items:" + items.size());

        System.out.println("Should have " + items.size() + " SELECT statements below.");
        for (Item item : items) {
            for (Bid bid : item.getBids()) {
                assertNotNull(bid.getItem());
                //System.out.println(bid.getId());
            }
        }

        System.out.println("Should have " + 1 + " SELECT statement below.");
        for (Item item : items) {
            for (Bid bid : item.getBids2()) {
                assertNotNull(bid.getItem());
                //System.out.println(bid.getId());
            }
        }
    }

    @Test
    void testSubSelectSolutionForManyToMany() {
        List<Item> items = itemRepository.findAll();
        System.out.println("Size of items:" + items.size());

        System.out.println("Should have " + items.size() + " SELECT statements below.");
        for (Item item : items) {
            for (Category category : item.getCategories()) {
                assertNotNull(category.getName());
                //System.out.println(bid.getId());
            }
        }

    }

}
