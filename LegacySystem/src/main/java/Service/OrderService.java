package Service;

import Service.model.OrderEntity;

import javax.jws.WebService;
import javax.ws.rs.*;

/**
 * 订单管理系统
 */
@WebService(name="OrderService")
public interface OrderService {

    //获取订单信息
    @Path("/getOrderInfo/{id}")
    @GET
    @Produces("application/json")
    OrderEntity getOrderInfoById(@PathParam("id") String id);
}
