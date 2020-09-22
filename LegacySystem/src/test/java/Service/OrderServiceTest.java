package Service;

import Service.impl.OrderServiceImpl;
import Service.model.OrderEntity;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderServiceTest {

    OrderServiceImpl orderService = new OrderServiceImpl();

    @Test
    public void getOrderInfoById() {
        OrderEntity order = orderService.getOrderInfoById("418458");
        assertEquals("418458", order.getId());
        assertEquals("3040339", order.getMaterialId());
        assertEquals(Long.valueOf(100), order.getNumber());
        assertEquals("Wed Nov 28 14:00:00 CST 2018", order.getDdl().toString());
    }
}
