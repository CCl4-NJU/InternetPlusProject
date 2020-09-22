package Service;

import Service.impl.AttendanceServiceImpl;
import Service.model.CalendarEntity;
import Service.model.ClassEntity;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AttendanceServiceTest {

    AttendanceServiceImpl attendanceService = new AttendanceServiceImpl();

    @Test
    public void getClassInfo() {
        List<ClassEntity> classInfo = attendanceService.getClassInfo();
        assertEquals(4, classInfo.size());
    }

    @Test
    public void getCalendarInfo() {
        List<CalendarEntity> calendarInfo = attendanceService.getCalendarInfo();
        assertEquals(65, calendarInfo.size());
    }
}
