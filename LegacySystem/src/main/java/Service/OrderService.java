package Service;

import Service.model.OrderEntity;
import Service.model.personnelEntity;

import javax.jws.WebService;

/**
 * 人事系统
 */
@WebService(name="OrderService")
public interface OrderService {

    //获取订单信息
    OrderEntity getOrderInfoById(String id);
}
