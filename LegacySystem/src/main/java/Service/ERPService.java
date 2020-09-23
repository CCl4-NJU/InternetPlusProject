package Service;


import Service.model.BOMEntity;
import Service.model.LineEntity;
import Service.model.MaterialEntity;
import Service.model.ResourceEntity;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * ERP系统
 */
@WebService(
        serviceName = "ERPService",
        name="ERPServiceSoap"
)
public interface ERPService {
    //获取人力资源（班组）信息
    List<ResourceEntity> getResourceTeamInfo();

    //获取生产线/设备资源信息

    //获取物品信息

    @Path("/material")
    @GET
    @Consumes({"application/xml", "application/json"})
    @Produces("application/json")
    MaterialEntity getMaterialInfoById(String id);

    @Path("/LineResourceById")
    @GET
    @Consumes({"application/xml", "application/json"})
    @Produces("application/json")
    LineEntity getLineResourceById(String id);

    @Path("/LineResource")
    @GET
    @Consumes({"application/xml", "application/json"})
    @Produces("application/json")
    List<LineEntity> getAllLineResources();

    //获取BOM信息
    @Path("/BOMById")
    @GET
    @Consumes({"application/xml", "application/json"})
    @Produces("application/json")
    BOMEntity getBOMById(String id);

    @Path("/BOM")
    @GET
    @Consumes({"application/xml", "application/json"})
    @Produces("application/json")
    List<BOMEntity> getAllBOMs();
}
