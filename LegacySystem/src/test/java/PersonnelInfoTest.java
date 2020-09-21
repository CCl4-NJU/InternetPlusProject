import Service.PersonnelService;
import Service.model.PersonnelEntity;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class PersonnelInfoTest {
    public static void main(String[] args) {
        try {
            URL wsdlDocumentLocation = new URL("http://localhost:8080/PersonnelService");
            QName sName = new QName("http://impl.Service/", "PersonnelService");
            Service service = Service.create(wsdlDocumentLocation, sName);
            PersonnelService personnelService = service.getPort(PersonnelService.class);
            PersonnelEntity oneStaff = personnelService.getStaffInfoById("1");
            System.out.println("Staff Id: " + oneStaff.getId());
            System.out.println("Staff Name: " + oneStaff.getName());
            System.out.println("Staff Position: " + oneStaff.getPosition());
            System.out.println("Staff Group: " + oneStaff.getGroupId());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
