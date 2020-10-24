package Service;

import Service.model.OrderEntity;

import javax.jws.WebService;
import javax.ws.rs.*;
import java.util.List;

/**
 * 订单管理系统
 */
@WebService(
        serviceName = "OrderService",
        name="OrderServiceSoap"
)
public interface OrderService {

    //获取订单信息
    OrderEntity getOrderInfoById(String id);

    List<OrderEntity> getAllOrders();
}
