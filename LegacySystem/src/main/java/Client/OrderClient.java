package Client;

import Service.OrderService;
import Service.model.OrderEntity;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class OrderClient {
    private OrderService orderService;
    public OrderClient(){
        URL orderWsdlDocumentLocation = null;
        try {
            orderWsdlDocumentLocation = new URL("http://localhost:8080/OrderService");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        QName sNameOrder = new QName("http://impl.Service/", "OrderService");
        Service serviceOrder = Service.create(orderWsdlDocumentLocation, sNameOrder);
        orderService = serviceOrder.getPort(OrderService.class);
    }
    public OrderEntity getOrderInfoById(String id){
        return orderService.getOrderInfoById(id);
    }
}
