package Service;

import Service.model.personnelEntity;

import javax.jws.WebService;

/**
 * 人事系统
 */
@WebService(name="personnelService")
public interface personnelService {

    //获取员工信息
    personnelEntity getStaffInfoById(int id);

    //进行身份认证
    String idAuthentication(int id);
}
