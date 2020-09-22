package Service;

import Service.model.*;

import java.util.Map;

public class Database {
    //模拟personnel表，主键key是工号
    public static Map<String, PersonnelEntity> tbl_personnel;
    //模拟class表，主键key是班次代码
    public static Map<Integer, ClassEntity> tbl_class;
    //模拟order表，主键key是订单号
    public static Map<String, OrderEntity> tbl_order;
    //模拟material表，主键key是物料编码
    public static Map<String, MaterialEntity> tbl_material;
    //模拟resource表中的生产线资源信息，主键key是生产线资源id
    public static Map<String, LineEntity> tbl_lineResources;
}
