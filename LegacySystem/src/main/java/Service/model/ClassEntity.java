package Service.model;

/**
 * 班次信息
 */
public class ClassEntity {
    //班次代码
    private ClassCode classCode;
    //班次名称
    private ClassName className;
    //工作时间段
    private String workingHours;

    public ClassCode getClassCode() {
        return classCode;
    }

    public void setClassCode(ClassCode classCode) {
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

    public ClassCode computeCode(String str) {
        switch (str) {
            case "全天":
                return ClassCode.WHOLE;
            case "早班":
                return ClassCode.DAY;
            case "晚班":
                return ClassCode.NIGHT;
            case "休息":
                return ClassCode.REST;
            default:
                return null;
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
 * 班次代码
 */
enum ClassCode {
    WHOLE,      //全天
    DAY,        //早班
    NIGHT,      //晚班
    REST        //休息
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