package Service;


import Service.model.MaterialEntity;

import javax.jws.WebService;

/**
 * ERP系统
 */
@WebService(name="ERPService")
public interface ERPService {
    //获取人力资源（班组）信息

    //获取生产线/设备资源信息

    //获取物品信息
    MaterialEntity getMaterialInfoById(String id);

    //获取BOM信息
}
