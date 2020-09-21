import Service.ERPService;
import Service.impl.ERPServiceImpl;
import Service.model.MaterialEntity;
import Service.model.OrderEntity;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class MaterialInfoTest {
    public static void main(String[] args) {
        try{
            URL wsdlDocumentLocation = new URL("http://localhost:8080/ERPService");
            QName sName = new QName("http://impl.Service/", "ERPService");
            Service service = Service.create(wsdlDocumentLocation, sName);
            ERPService erpService = service.getPort(ERPService.class);
            MaterialEntity material = erpService.getMaterialInfoById("3000608");
            System.out.println("Material Id: " + material.getId());
            System.out.println("Description: " + material.getDescription());
            System.out.println("Compute Unit: " + material.getMeasurement());
            System.out.println("Attribute: " + material.getMaterialAttr());
            System.out.println("Preparation: " + material.getPreparation());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
