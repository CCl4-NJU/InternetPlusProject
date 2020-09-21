package Service.model;

/**
 * 物品信息
 */
public class MaterialEntity {
    //物料编码
    private String id;
    //物料描述
    private String description;
    //物品属性
    private MaterialAttr materialAttr;
    //计量单位
    private Measurement measurement;
    //备料方式
    private Preparation preparation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MaterialAttr getMaterialAttr() {
        return materialAttr;
    }

    public void setMaterialAttr(MaterialAttr materialAttr) {
        this.materialAttr = materialAttr;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Preparation getPreparation() {
        return preparation;
    }

    public void setPreparation(Preparation preparation) {
        this.preparation = preparation;
    }

    //根据物品属性的中文名获取对应枚举值
    public MaterialAttr computeAttr(String str){
        switch (str) {
            case "成品":
                return MaterialAttr.FINISHED;
            case "半成品":
                return MaterialAttr.SEMI_FINISHED;
            case "原材料":
                return MaterialAttr.RAW;
            default:
                return null;
        }
    }

    //根据计量单位的中文名获取对应枚举值
    public Measurement computeMeasurement(String str){
        if(str.toUpperCase().equals("PCS")){
            return Measurement.PCS;
        } else if(str.toUpperCase().equals("KG")){
            return Measurement.KG;
        }else{
            return null;
        }
    }

    //根据备料方式的中文名获取对应枚举值
    public Preparation computePrep(String str){
        if(str.equals("自制")){
            return Preparation.MAKE;
        } else if(str.equals("外购")){
            return Preparation.BUY;
        } else{
            return null;
        }
    }
}

/**
 * 物品属性
 */
enum MaterialAttr{
    FINISHED,       //成品
    SEMI_FINISHED,  //半成品
    RAW             //原材料
}

/**
 * 计量单位
 */
enum Measurement{
    PCS,
    KG
}

/**
 * 备料方式
 */
enum Preparation{
    MAKE, //自制
    BUY   //外购
}