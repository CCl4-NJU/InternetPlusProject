package Service.model;

/**
 *人力资源（班组）信息
 */
public class ResourceEntity {
    //项目
    private String project;
    //资源代码
    private String resourceId;
    //资源名称
    private String resourceName;
    //所属资源
    private String resourceBl;
    //资源类型
    private String resourceType;

    //资源量
    private String resourceNum;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceBl() {
        return resourceBl;
    }

    public void setResourceBl(String resourceBl) {
        this.resourceBl = resourceBl;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceNum() {
        return resourceNum;
    }

    public void setResourceNum(String resourceNum) {
        this.resourceNum = resourceNum;
    }
}

