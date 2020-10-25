package Service;

import Service.impl.OrderServiceImpl;
import Service.model.OrderEntity;
import org.junit.Test;

import java.util.Date;
import java.util.List;

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

    @Test
    public void getAllOrders(){
        List<OrderEntity> orderEntityList = orderService.getAllOrders();
        assertEquals(78,orderEntityList.size());
    }

    @Test
    public void insertOrder(){
        OrderEntity order = new OrderEntity();
        order.setId("400000");
        order.setMaterialId("3000000");
        order.setNumber(10L);
        order.setDdl(new Date("2020/10/25"));
        int result = orderService.insertOrder(order);
        assertEquals(1, result);
    }
}
