package Client;

import Service.*;
import Service.model.*;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class PersonnelClient {
    private PersonnelService personnelService;
    public PersonnelClient(){
        URL personnelWsdlDocumentLocation = null;
        try {
            personnelWsdlDocumentLocation = new URL("http://localhost:8080/PersonnelService");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        QName sNamePersonnel = new QName("http://impl.Service/", "PersonnelService");
        Service servicePersonnel = Service.create(personnelWsdlDocumentLocation, sNamePersonnel);
        personnelService = servicePersonnel.getPort(PersonnelService.class);
    }
    public PersonnelEntity getStaffInfoById(String id){
        return personnelService.getStaffInfoById(id);
    }
    public String idAuthentication(String id){
        return personnelService.idAuthentication(id);
    }
}
