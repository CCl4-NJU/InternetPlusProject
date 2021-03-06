package Service;

import Service.impl.AttendanceServiceImpl;
import Service.impl.ERPServiceImpl;
import Service.impl.OrderServiceImpl;
import Service.impl.PersonnelServiceImpl;
import Service.model.BOMEntity;

import javax.xml.ws.Endpoint;
import java.util.List;

public class Initiator {
    /**
     * 启动
     * @param args
     */
    public static void main(String[] args) {
        String personnelAddr = "http://localhost:8080/PersonnelService";
        String orderAddr = "http://localhost:8080/OrderService";
        String erpAddr = "http://localhost:8080/ERPService";
        String attendanceAddr = "http://localhost:8080/AttendanceService";

        System.out.println("Ready to Start...");

        Endpoint.publish(personnelAddr, new PersonnelServiceImpl());
        Endpoint.publish(orderAddr, new OrderServiceImpl());
        Endpoint.publish(erpAddr, new ERPServiceImpl());
        Endpoint.publish(attendanceAddr, new AttendanceServiceImpl());

        System.out.println("Publish Success!");
    }
}
