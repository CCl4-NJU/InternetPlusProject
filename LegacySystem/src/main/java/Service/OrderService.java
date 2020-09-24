package Service;

import Service.model.OrderEntity;

import javax.jws.WebService;
import javax.ws.rs.*;

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
}
