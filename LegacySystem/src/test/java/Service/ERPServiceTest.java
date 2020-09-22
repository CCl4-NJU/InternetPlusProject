package Service;

import Service.impl.ERPServiceImpl;
import Service.model.MaterialEntity;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ERPServiceTest {

    ERPServiceImpl erpService = new ERPServiceImpl();

    @Test
    public void getMaterialInfoById() {
        MaterialEntity material = erpService.getMaterialInfoById("3000608");
        assertEquals("3000608", material.getId());
        assertEquals("UT 4-TWIN HV", material.getDescription());
        assertEquals(material.computeAttr("成品"), material.getMaterialAttr());
        assertEquals(material.computeMeasurement("PCS"), material.getMeasurement());
        assertEquals(material.computePrep("自制"), material.getPreparation());
    }
}
