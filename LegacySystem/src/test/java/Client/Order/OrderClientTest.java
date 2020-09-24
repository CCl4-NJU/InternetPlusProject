package Client.Order;

import Client.OrderClient;
import Service.impl.OrderServiceImpl;
import Service.model.OrderEntity;
import org.junit.Before;
import org.junit.Test;

import javax.xml.ws.Endpoint;

import static org.junit.Assert.assertEquals;

public class OrderClientTest {
    private static OrderClient client;
    @Before
    public void setup(){
        if(client!=null) return;
        String orderAddr = "http://localhost:8080/OrderService";
        Endpoint.publish(orderAddr, new OrderServiceImpl());
        client = new OrderClient();
    }
    @Test
    public void getOrderInfoById() {
        OrderEntity order = client.getOrderInfoById("418458");
        assertEquals("418458", order.getId());
        assertEquals("3040339", order.getMaterialId());
        assertEquals(Long.valueOf(100), order.getNumber());
        assertEquals("Wed Nov 28 14:00:00 CST 2018", order.getDdl().toString());
    }
}
