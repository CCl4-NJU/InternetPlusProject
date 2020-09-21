package Service;

import Service.model.MaterialEntity;
import Service.model.OrderEntity;
import Service.model.PersonnelEntity;

import java.util.Map;

public class Database {
    //模拟personnel表，主键key是工号
    public static Map<String, PersonnelEntity> tbl_personnel;
    //模拟order表，主键key是订单号
    public static Map<String, OrderEntity> tbl_order;
    //模拟material表，主键key是物料编码
    public static Map<String, MaterialEntity> tbl_material;
}
