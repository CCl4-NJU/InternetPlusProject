package Service.impl;

import Service.model.personnelEntity;
import Service.personnelService;
import javax.jws.WebService;

/**
 * 人事系统
 */
@WebService(
        name = "personnelServiceImpl",
        endpointInterface = "Service.personnelService"
)
public class personnelServiceImpl implements personnelService {
    /**
     * 获取员工信息
     * @param id
     * @return
     */
    public personnelEntity getStaffInfoById(int id) {
        // TODO 读取csv，获取员工信息
        personnelEntity staff = new personnelEntity();
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
