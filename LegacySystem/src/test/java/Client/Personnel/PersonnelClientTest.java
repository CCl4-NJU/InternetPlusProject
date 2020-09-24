package Client.Personnel;

import Client.PersonnelClient;
import Service.impl.PersonnelServiceImpl;
import Service.model.PersonnelEntity;
import org.junit.Before;
import org.junit.Test;

import javax.xml.ws.Endpoint;

import static org.junit.Assert.assertEquals;

public class PersonnelClientTest {
    private static PersonnelClient client;
    @Before
    public void setup(){
        if(client!=null) return;
        String personnelAddr = "http://localhost:8080/PersonnelService";
        Endpoint.publish(personnelAddr, new PersonnelServiceImpl());
        client = new PersonnelClient();
    }
    @Test
    public void getStaffInfoById() {
        PersonnelEntity staffInfo = client.getStaffInfoById("1");
        assertEquals("1", staffInfo.getId());
        assertEquals("童玲", staffInfo.getName());
        assertEquals("组长", staffInfo.getPosition());
        assertEquals("5", staffInfo.getGroupId());
    }
    @Test
    public void idAuthentication() {
        String actualPosition = client.idAuthentication("1");
        assertEquals("组长", actualPosition);
    }
}
