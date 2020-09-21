package Service.impl;

import Service.model.PersonnelEntity;
import Service.PersonnelService;
import javax.jws.WebService;

/**
 * 人事系统
 */
@WebService(
        name = "personnelServiceImpl",
        endpointInterface = "Service.PersonnelService"
)
public class PersonnelServiceImpl implements PersonnelService {
    /**
     * 获取员工信息
     * @param id
     * @return
     */
    public PersonnelEntity getStaffInfoById(int id) {
        // TODO 读取csv，获取员工信息
        PersonnelEntity staff = new PersonnelEntity();
        staff.setId(1);
        staff.setName("Mike");
        staff.setPosition("Manager");
        staff.setGroupId(1);
        return staff;
    }

    /**
     * 进行身份认证
     * @param id
     * @return
     */
    public String idAuthentication(int id) {
        // TODO
        return getStaffInfoById(id).getName();
    }
}
