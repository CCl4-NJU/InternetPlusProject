package Service.impl;

import Service.Database;
import Service.ERPService;
import Service.EmptyClass;
import Service.model.ClassEntity;
import Service.model.MaterialEntity;
import Service.model.ResourceEntity;
import Service.util.ExcelReadUtil;

import javax.jws.WebService;
import java.io.File;
import java.net.URISyntaxException;
import java.util.*;

/**
 * ERP系统
 */
@WebService(
        serviceName = "ERPService",
        name = "ERPServiceSoap",
        endpointInterface = "Service.ERPService"
)
public class ERPServiceImpl implements ERPService {

    /**
     * 取人力资源（班组）信息
     */
    public List<ResourceEntity> getResourceTeamInfo(){
        List<ResourceEntity> resourceInfo=new ArrayList<>();
        Database.tbl_resource=new HashMap<>();
        try {
            //使用相对路径
            String excelFilePath = Objects.requireNonNull(EmptyClass.class.getClassLoader()
                    .getResource("./excel/resource.xlsx")).toURI().getPath();
            HashMap<String, ArrayList<ArrayList<String>>> excelReadMap = ExcelReadUtil.readExcel(new File(excelFilePath), 2);

            if (excelReadMap != null) {
                ArrayList<ArrayList<String>> target = excelReadMap.get(
                        excelReadMap.keySet().iterator().next()
                );
                for (List<String> row : target) {
                    ResourceEntity tempResource =new ResourceEntity();
                    tempResource.setProject(row.get(0));
                    tempResource.setResourceId(row.get(1));
                    tempResource.setResourceName(row.get(2));
                    tempResource.setResourceBl(row.get(3));
                    tempResource.setResourceType(row.get(4));
                    tempResource.setResourceNum(row.get(5));
                    resourceInfo.add(tempResource);
                }
            }

            if(Database.tbl_resource==null){
                for (ResourceEntity resourceEntity : resourceInfo) {
                    Database.tbl_resource.put(resourceEntity.getResourceId(), resourceEntity);
                }
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return resourceInfo;
    }

    /**
     * 获取订单信息
     * @param id
     * @return
     */
    public MaterialEntity getMaterialInfoById(String id) {
        if(Database.tbl_material==null){
            try {
                initTblMaterial();
            } catch (URISyntaxException e){
                e.printStackTrace();
            }
        }

        return Database.tbl_material.get(id);
    }

    private static void initTblMaterial() throws URISyntaxException {
        Database.tbl_material = new HashMap<>();
        //使用相对路径
        String excelFilePath = new EmptyClass().getClass().getClassLoader()
                .getResource("./excel/material.xlsx").toURI().getPath();
        HashMap<String, ArrayList<ArrayList<String>>> excelReadMap = ExcelReadUtil.readExcel(new File(excelFilePath), 1);

        if(excelReadMap != null){
            ArrayList<ArrayList<String>> target = excelReadMap.get(
                    excelReadMap.keySet().iterator().next()
            );
            for(List<String> row : target){
                MaterialEntity tempMaterial = new MaterialEntity();
                tempMaterial.setId(row.get(0));
                tempMaterial.setDescription(row.get(1));
                tempMaterial.setMaterialAttr(tempMaterial.computeAttr(row.get(2)));
                tempMaterial.setMeasurement(tempMaterial.computeMeasurement(row.get(3)));
                tempMaterial.setPreparation(tempMaterial.computePrep(row.get(8)));
                Database.tbl_material.put(tempMaterial.getId(), tempMaterial);
            }
        }
    }
}
