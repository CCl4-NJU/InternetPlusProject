package Service;

import Service.impl.ERPServiceImpl;
import Service.model.BOMEntity;
import Service.model.ClassEntity;
import Service.model.MaterialEntity;
import Service.model.ResourceEntity;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ERPServiceTest {

    ERPServiceImpl erpService = new ERPServiceImpl();

    @Test
    public void getResourceTeamInfoTest() {
        List<ResourceEntity> resourceInfo = erpService.getResourceTeamInfo();
        assertEquals(65, resourceInfo.size());
    }

    @Test
    public void getMaterialInfoById() {
        MaterialEntity material = erpService.getMaterialInfoById("3000608");
        assertEquals("3000608", material.getId());
        assertEquals("UT 4-TWIN HV", material.getDescription());
        assertEquals(material.computeAttr("成品"), material.getMaterialAttr());
        assertEquals(material.computeMeasurement("PCS"), material.getMeasurement());
        assertEquals(material.computePrep("自制"), material.getPreparation());
    }
    @Test
    public void getBOMById(){
        BOMEntity bom=erpService.getBOMById("3211498装配");
        assertEquals("3211498", bom.getId());
        assertEquals("装配", bom.getProcess());
        assertEquals(5, bom.getMainResource().size());
        assertEquals(1, bom.getLineResource().size());
        assertEquals("0.1", bom.getChangeTime());
        assertEquals("250", bom.getStandardOutput());
        assertEquals(2, bom.getWorkerCount());
    }

    @Test
    public void getAllBoms(){
        List<BOMEntity> bomEntityList = erpService.getAllBOMs();
        assertEquals(bomEntityList.size(), 14);
    }
}
