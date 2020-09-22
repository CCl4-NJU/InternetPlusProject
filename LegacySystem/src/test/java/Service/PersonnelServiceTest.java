package Service;

import Service.impl.PersonnelServiceImpl;
import Service.model.PersonnelEntity;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonnelServiceTest {

    PersonnelServiceImpl personnelService = new PersonnelServiceImpl();

    @Test
    public void getStaffInfoById() {
        PersonnelEntity staffInfo = personnelService.getStaffInfoById("1");
        assertEquals("1", staffInfo.getId());
        assertEquals("童玲", staffInfo.getName());
        assertEquals("组长", staffInfo.getPosition());
        assertEquals("5", staffInfo.getGroupId());
    }

    @Test
    public void idAuthentication() {
        String actualPosition = personnelService.idAuthentication("1");
        assertEquals("组长", actualPosition);
    }
}
