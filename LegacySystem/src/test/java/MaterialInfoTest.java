import Service.ERPService;
import Service.impl.ERPServiceImpl;
import Service.model.MaterialEntity;

public class MaterialInfoTest {
    public static void main(String[] args) {
        ERPService service = new ERPServiceImpl();
        MaterialEntity testEntity = service.getMaterialInfoById("3001605");
        System.out.println(testEntity.getId()+","+testEntity.getDescription()+","+testEntity.getMaterialAttr()+","
                +testEntity.getMeasurement()+","+testEntity.getPreparation());
    }
}
