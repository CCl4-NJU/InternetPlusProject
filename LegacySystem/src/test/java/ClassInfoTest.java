import Service.AttendanceService;
import Service.model.ClassEntity;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ClassInfoTest {
    public static void main(String[] args) {
        try {
            URL wsdlDocumentLocation = new URL("http://localhost:8080/AttendanceService");
            QName sName = new QName("http://impl.Service/", "AttendanceService");
            Service service = Service.create(wsdlDocumentLocation, sName);
            AttendanceService attendanceService = service.getPort(AttendanceService.class);
            List<ClassEntity> classInfo = attendanceService.getClassInfo();
            for (ClassEntity each : classInfo) {
                System.out.println("Class Code: " + each.getClassCode());
                System.out.println("Class Name: " + each.getClassName());
                System.out.println("Working Hour: " + each.getWorkingHours());
                System.out.println();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
