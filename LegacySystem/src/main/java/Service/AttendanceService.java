package Service;

import Service.model.ClassEntity;

import javax.jws.WebService;
import java.util.List;

/**
 * 考勤系统
 */
@WebService(
        serviceName = "AttendanceService",
        name = "AttendanceServiceSoap"
)
public interface AttendanceService {
    //获取班次信息
    List<ClassEntity> getClassInfo();

    //获取人力资源（班组）排班信息
}
