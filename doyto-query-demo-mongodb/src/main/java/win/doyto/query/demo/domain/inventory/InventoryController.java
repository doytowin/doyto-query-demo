package win.doyto.query.demo.domain.inventory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.doyto.query.web.controller.AbstractEIQController;

/**
 * InventoryController
 *
 * @author yuanzhen on 2022/6/13
 */
@RestController
@RequestMapping("inventory")
public class InventoryController extends AbstractEIQController<InventoryEntity, String, InventoryQuery> {
}
