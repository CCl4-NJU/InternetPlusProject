package Service.model;

import java.util.Date;

/**
 * 订单信息
 */
public class OrderEntity {
    //订单号
    private String id;
    //物料号码
    private String materialId;
    //订单数量
    private Long number;
    //交期
    private Date ddl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Date getDdl() {
        return ddl;
    }

    public void setDdl(Date ddl) {
        this.ddl = ddl;
    }
}
