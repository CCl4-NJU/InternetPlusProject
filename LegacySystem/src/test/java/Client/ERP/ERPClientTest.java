package Client.ERP;

import Client.ERPClient;
import Service.impl.ERPServiceImpl;
import Service.model.BOMEntity;
import Service.model.MaterialEntity;
import Service.model.ResourceEntity;
import org.junit.Before;
import org.junit.Test;

import javax.xml.ws.Endpoint;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ERPClientTest {
    private static ERPClient client;
    @Before
    public void setup(){
        if(client!=null) return;
        String erpAddr = "http://localhost:8080/ERPService";
        Endpoint.publish(erpAddr, new ERPServiceImpl());
        client = new ERPClient();
    }
    @Test
    public void getResourceTeamInfoTest() {
        List<ResourceEntity> resourceInfo = client.getResourceTeamInfo();
        assertEquals(65, resourceInfo.size());
    }
    @Test
    public void getMaterialInfoById() {
        MaterialEntity material = client.getMaterialInfoById("3000608");
        assertEquals("3000608", material.getId());
        assertEquals("UT 4-TWIN HV", material.getDescription());
        assertEquals(material.computeAttr("成品"), material.getMaterialAttr());
        assertEquals(material.computeMeasurement("PCS"), material.getMeasurement());
        assertEquals(material.computePrep("自制"), material.getPreparation());
    }
    @Test
    public void getBOMById(){
        BOMEntity bom=client.getBOMById("3036466");
        assertEquals("3036466", bom.getId());
        assertEquals("9761340", bom.getMaterials().get(0));
        assertEquals(5, bom.getMaterials().size());
        assertEquals(5, bom.getMaterialCount().size());
        assertEquals(9, bom.getMainResource().size());
        assertEquals(3, bom.getLineResource().size());
        assertEquals("0.1H", bom.getChangeTime());
        assertEquals("178个/小时", bom.getStandardOutput());
        assertEquals(4, bom.getWorkerCount());
    }
}
