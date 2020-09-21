package Service.impl;

import Service.model.PersonnelEntity;
import Service.PersonnelService;
import javax.jws.WebService;

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
        // TODO 读取csv，获取员工信息
        PersonnelEntity staff = new PersonnelEntity();
        staff.setId("1");
        staff.setName("Mike");
        staff.setPosition("Manager");
        staff.setGroupId("1");
        return staff;
    }

    /**
     * 进行身份认证
     * @param id
     * @return
     */
    public String idAuthentication(String id) {
        // TODO
        return getStaffInfoById(id).getName();
    }
}
