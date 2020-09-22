package Service.impl;

import Service.Database;
import Service.EmptyClass;
import Service.PersonnelService;
import Service.model.PersonnelEntity;
import Service.util.ExcelReadUtil;

import javax.jws.WebService;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 人事系统
 */
@WebService(
        serviceName = "PersonnelService",
        name = "PersonnelServiceSoap",
        endpointInterface = "Service.PersonnelService"
)
public class PersonnelServiceImpl implements PersonnelService {
    /**
     * 获取员工信息
     * @param id
     * @return
     */
    public PersonnelEntity getStaffInfoById(String id) {
        if (Database.tbl_personnel == null) {
            try {
                initTblPersonnel();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }

        return Database.tbl_personnel.get(id);
    }

    /**
     * 进行身份认证
     *
     * @param id
     * @return
     */
    public String idAuthentication(String id) {
        PersonnelEntity personnel = getStaffInfoById(id);
        if (personnel != null) {
            return personnel.getName();
        }
        return null;
    }

    private static void initTblPersonnel() throws URISyntaxException {
        Database.tbl_personnel = new HashMap<>();
        //使用相对路径
        String excelFilePath = new EmptyClass().getClass().getClassLoader()
                .getResource("./excel/personnel.xlsx").toURI().getPath();
        HashMap<String, ArrayList<ArrayList<String>>> excelReadMap = ExcelReadUtil.readExcel(new File(excelFilePath), 1);

        if (excelReadMap != null) {
            ArrayList<ArrayList<String>> target = excelReadMap.get(
                    excelReadMap.keySet().iterator().next()
            );
            for (List<String> row : target) {
                PersonnelEntity tempPersonnel = new PersonnelEntity();
                tempPersonnel.setId(row.get(0));
                tempPersonnel.setName(row.get(1));
                tempPersonnel.setPosition(row.get(2));
                tempPersonnel.setGroupId(row.get(3));
                Database.tbl_personnel.put(tempPersonnel.getId(), tempPersonnel);
            }
        }
    }
}
