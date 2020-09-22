package Service.model;

public class LineEntity {
    //生产线资源id
    private String id;
    //资源名称
    private String resourceName;
    //资源类型
    private String resourceType;
    //资源量
    private int count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getResourcetype() {
        return resourceType;
    }

    public void setResourcetype(String resourcetype) {
        this.resourceType = resourcetype;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}