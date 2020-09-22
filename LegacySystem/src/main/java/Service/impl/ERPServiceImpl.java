package Service.impl;

import Service.Database;
import Service.ERPService;
import Service.EmptyClass;
import Service.model.LineEntity;
import Service.model.ClassEntity;
import Service.model.MaterialEntity;
import Service.model.ResourceEntity;
import Service.util.ExcelReadUtil;

import javax.jws.WebService;
import javax.sound.sampled.Line;
import javax.xml.crypto.Data;
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

    /**
     * 根据id获取生产线资源信息
     * @param id  生产线资源id，形如line04
     * @return 该生产线相关信息
     */
    public LineEntity getLineResourceById(String id){
        if(Database.tbl_lineResources==null){
            try {
                initTblLineResources();
            } catch (URISyntaxException e){
                e.printStackTrace();
            }
        }

        return Database.tbl_lineResources.get(id);
    }

    /**
     * 获取全部生产线信息
     * @return 返回List，包含所有生产线信息，每个信息都为LineEntity格式
     */
    public List<LineEntity> getAllLineResources(){
        if(Database.tbl_lineResources==null){
            try {
                initTblLineResources();
            } catch (URISyntaxException e){
                e.printStackTrace();
            }
        }
        //将Database中的map转换为list
        List<LineEntity> tempList = new ArrayList<>();
        for(Map.Entry<String, LineEntity> entry: Database.tbl_lineResources.entrySet()){
            tempList.add(entry.getValue());
        }
        return tempList;
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

    /**
     * 初始化生产线资源表
     * @throws URISyntaxException
     */
    private static void initTblLineResources() throws  URISyntaxException{
        Database.tbl_lineResources = new HashMap<>();

        String excelFilePath = new EmptyClass().getClass().getClassLoader()
                .getResource("./excel/resource.xlsx").toURI().getPath();
        HashMap<String, ArrayList<ArrayList<String>>> excelReadMap = ExcelReadUtil.readExcel(new File(excelFilePath), 1);

        if (excelReadMap != null){
            ArrayList<ArrayList<String>> target = excelReadMap.get(
                    excelReadMap.keySet().iterator().next()
            );
            for(List<String> row : target){
                if (row.get(2).equals("线体")){
                    LineEntity temp = new LineEntity();
                    temp.setId(row.get(1));
                    temp.setResourceName(row.get(2));
                    temp.setResourcetype(row.get(4));
                    temp.setCount(Integer.parseInt(row.get(5)));
                    Database.tbl_lineResources.put(temp.getId(), temp);
                }
            }
        }
    }
}
