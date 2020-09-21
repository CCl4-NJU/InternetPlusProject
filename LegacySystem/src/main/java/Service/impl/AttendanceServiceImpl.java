package Service.impl;

import Service.AttendanceService;
import Service.EmptyClass;
import Service.model.ClassEntity;
import Service.util.ExcelReadUtil;

import javax.jws.WebService;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 考勤系统
 */
@WebService(
        serviceName = "AttendanceService",
        name = "AttendanceServiceSoap",
        endpointInterface = "Service.AttendanceService"
)
public class AttendanceServiceImpl implements AttendanceService {
    /**
     * 获取班次信息
     *
     * @return
     */
    @Override
    public List<ClassEntity> getClassInfo() {
        List<ClassEntity> classInfo = new ArrayList<>();
        try {
            //使用相对路径
            String excelFilePath = new EmptyClass().getClass().getClassLoader()
                    .getResource("./excel/class.xlsx").toURI().getPath();
            HashMap<String, ArrayList<ArrayList<String>>> excelReadMap = ExcelReadUtil.readExcel(new File(excelFilePath), 1);

            if (excelReadMap != null) {
                ArrayList<ArrayList<String>> target = excelReadMap.get(
                        excelReadMap.keySet().iterator().next()
                );
                for (List<String> row : target) {
                    ClassEntity tempClass = new ClassEntity();
                    tempClass.setClassCode(tempClass.computeCode(row.get(0)));
                    tempClass.setClassName(tempClass.computeName(row.get(1)));
                    tempClass.setWorkingHours(row.get(2));
                    classInfo.add(tempClass);
                }
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return classInfo;
    }
}
