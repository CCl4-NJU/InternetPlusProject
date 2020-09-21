import Service.OrderService;
import Service.impl.OrderServiceImpl;
import Service.model.OrderEntity;
import org.apache.cxf.jaxrs.client.WebClient;

public class OrderInfoTest {
    public static void main(String[] args) {
//        OrderService service = new OrderServiceImpl();
//        OrderEntity testEntity = service.getOrderInfoById("417174");
//        System.out.println(testEntity.getId()+","+testEntity.getMaterialId()+","+testEntity.getNumber()+","
//        +testEntity.getDdl());
        WebClient
                .create("http://localhost:8080/OrderService/getOrderInfo/417174")
                .get();
    }
}
