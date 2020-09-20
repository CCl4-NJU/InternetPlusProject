package Service;

import Service.impl.OrderServiceImpl;
import Service.impl.personnelServiceImpl;

import javax.xml.ws.Endpoint;

public class Initiator {
    /**
     * 启动
     * @param args
     */
    public static void main(String[] args) {
        String address = "http://localhost:8080/personnelService";
        String orderAddr = "http://localhost:8080/OrderService";
        System.out.println("Ready to Start...");
        Endpoint.publish(address, new personnelServiceImpl());
        Endpoint.publish(orderAddr, new OrderServiceImpl());
        System.out.println("Publish Success!");
        System.out.println("Address:" + address);
    }
}
