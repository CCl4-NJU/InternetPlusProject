package Service;


import Service.model.MaterialEntity;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * ERP系统
 */
@WebService(
        serviceName = "ERPService",
        name="ERPServiceSoap"
)
public interface ERPService {
    //获取人力资源（班组）信息

    //获取生产线/设备资源信息

    //获取物品信息

    @Path("/material")
    @GET
    @Consumes({"application/xml","application/json"})
    @Produces("application/json")
    MaterialEntity getMaterialInfoById(String id);

    //获取BOM信息
}
