package Client;

import Service.ERPService;
import Service.model.BOMEntity;
import Service.model.LineEntity;
import Service.model.MaterialEntity;
import Service.model.ResourceEntity;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ERPClient {
    private ERPService erpService;
    public ERPClient(){
        URL erpWsdlDocumentLocation = null;
        try {
            erpWsdlDocumentLocation = new URL("http://localhost:8080/ERPService");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        QName sNameERP = new QName("http://impl.Service/", "ERPService");
        Service serviceERP = Service.create(erpWsdlDocumentLocation, sNameERP);
        erpService = serviceERP.getPort(ERPService.class);
    }
    public List<ResourceEntity> getResourceTeamInfo(){
        return erpService.getResourceTeamInfo();
    }
    public MaterialEntity getMaterialInfoById(String id){
        return erpService.getMaterialInfoById(id);
    }
    public LineEntity getLineResourceById(String id){
        return erpService.getLineResourceById(id);
    }
    public List<LineEntity> getAllLineResources(){
        return erpService.getAllLineResources();
    }
    public BOMEntity getBOMById(String id){
        return erpService.getBOMById(id);
    }
    public List<BOMEntity> getAllBOMs(){
        return erpService.getAllBOMs();
    }
}
