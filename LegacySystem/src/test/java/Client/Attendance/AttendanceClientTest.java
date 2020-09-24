package Client.Attendance;

import Client.AttendanceClient;
import Service.impl.AttendanceServiceImpl;
import Service.model.CalendarEntity;
import Service.model.ClassEntity;
import org.junit.Before;
import org.junit.Test;

import javax.xml.ws.Endpoint;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AttendanceClientTest {
    private static AttendanceClient client;
    @Before
    public void setup(){
        if(client!=null) return;
        String attendanceAddr = "http://localhost:8080/AttendanceService";
        Endpoint.publish(attendanceAddr, new AttendanceServiceImpl());
        client = new AttendanceClient();
    }
    @Test
    public void getClassInfo() {
        List<ClassEntity> classInfo = client.getClassInfo();
        assertEquals(4, classInfo.size());
    }
    @Test
    public void getCalendarInfo() {
        List<CalendarEntity> calendarInfo = client.getCalendarInfo();
        assertEquals(65, calendarInfo.size());
    }
}
