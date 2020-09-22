import Service.impl.AttendanceServiceImpl;
import Service.model.CalendarEntity;

import java.util.List;

public class CalendarInfoTest {
    public static void main(String[] args) {
        AttendanceServiceImpl tmp = new AttendanceServiceImpl();
        List<CalendarEntity> calendarInfo = tmp.getCalendarInfo();
        for (CalendarEntity each : calendarInfo) {
            System.out.println(each.getResourceCode());
            System.out.println(each.getClassCode());
            System.out.println();
        }
    }

}
