package Service.model;

import java.util.List;

public class BOMEntity {
    private String id;
    //工艺
    private String process;
    //主资源（人力）
    private List<String>  mainResource;
    //副资源（机器）
    private List<String>  lineResource;
    //换线时间
    private String changeTime;
    //标准产能
    private String standardOutput;
    //产品规定生产人员
    private int workerCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public List<String> getMainResource() {
        return mainResource;
    }

    public void setMainResource(List<String> mainResource) {
        this.mainResource = mainResource;
    }

    public List<String> getLineResource() {
        return lineResource;
    }

    public void setLineResource(List<String> lineResource) {
        this.lineResource = lineResource;
    }

    public String getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(String changeTime) {
        this.changeTime = changeTime;
    }

    public String getStandardOutput() {
        return standardOutput;
    }

    public void setStandardOutput(String standardOutput) {
        this.standardOutput = standardOutput;
    }

    public int getWorkerCount() {
        return workerCount;
    }

    public void setWorkerCount(int workerCount) {
        this.workerCount = workerCount;
    }
}
