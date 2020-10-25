package Service;

import Service.model.OrderEntity;

import javax.jws.WebService;
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

    //获取订单信息
    List<OrderEntity> getAllOrders();

    //插入订单
    int insertOrder(OrderEntity order);
}
