package Service.model;

/**
 * 班次信息
 */
public class ClassEntity {
    //班次代码（0:全天，1：早班，2：晚班，3：休息）
    private int classCode;
    //班次名称
    private ClassName className;
    //工作时间段
    private String workingHours;

    public int getClassCode() {
        return classCode;
    }

    public void setClassCode(int classCode) {
        this.classCode = classCode;
    }

    public ClassName getClassName() {
        return className;
    }

    public void setClassName(ClassName className) {
        this.className = className;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public int computeCode(String str) {
        switch (str) {
            case "全天":
                return 0;
            case "早班":
                return 1;
            case "晚班":
                return 2;
            case "休息":
                return 3;
            default:
                return -1;
        }
    }

    public ClassName computeName(String str) {
        switch (str) {
            case "全天":
                return ClassName.WHOLE;
            case "早班":
                return ClassName.DAY;
            case "晚班":
                return ClassName.NIGHT;
            case "":
                return ClassName.REST;
            default:
                return null;
        }
    }
}

/**
 * 班次名称
 */
enum ClassName {
    WHOLE,      //全天
    DAY,        //早班
    NIGHT,      //晚班
    REST        //休息
}