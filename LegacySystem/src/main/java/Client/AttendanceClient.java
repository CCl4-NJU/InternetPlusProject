package Client;

import Service.AttendanceService;
import Service.model.CalendarEntity;
import Service.model.ClassEntity;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class AttendanceClient {
    private AttendanceService attendanceService;
    public AttendanceClient(){
        URL attendanceWsdlDocumentLocation = null;
        try {
            attendanceWsdlDocumentLocation = new URL("http://localhost:8080/AttendanceService");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        QName sNameAttendance = new QName("http://impl.Service/", "AttendanceService");
        Service serviceAttendance = Service.create(attendanceWsdlDocumentLocation, sNameAttendance);
        attendanceService = serviceAttendance.getPort(AttendanceService.class);
    }
    public List<ClassEntity> getClassInfo(){
        return attendanceService.getClassInfo();
    }
    public List<CalendarEntity> getCalendarInfo(){
        return attendanceService.getCalendarInfo();
    }
}
