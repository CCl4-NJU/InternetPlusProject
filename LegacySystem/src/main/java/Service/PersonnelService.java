package Service;

import Service.model.PersonnelEntity;

import javax.jws.WebService;

/**
 * 人事系统
 */
@WebService(name="personnelService")
public interface PersonnelService {

    //获取员工信息
    PersonnelEntity getStaffInfoById(int id);

    //进行身份认证
    String idAuthentication(int id);
}