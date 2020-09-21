import Service.OrderService;
import Service.model.OrderEntity;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class OrderInfoTest {
    public static void main(String[] args) {
        try{
            URL wsdlDocumentLocation = new URL("http://localhost:8080/OrderService");
            QName sName = new QName("http://impl.Service/", "OrderService");
            Service service = Service.create(wsdlDocumentLocation, sName);
            OrderService orderService = service.getPort(OrderService.class);
            OrderEntity order = orderService.getOrderInfoById("418458");
            System.out.println("Order Id: " + order.getId());
            System.out.println("Material Id: " + order.getMaterialId());
            System.out.println("Number: " + order.getNumber());
            System.out.println("DDL: " + order.getDdl());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
