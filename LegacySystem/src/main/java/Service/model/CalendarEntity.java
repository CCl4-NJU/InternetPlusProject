package Service.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalendarEntity {
    private String resourceCode;
    private List<WorkDay> workDays;
    private int classCode;
    private String remarks;

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public List<WorkDay> getWorkDays() {
        return workDays;
    }

    public void setWorkDays(List<WorkDay> workDays) {
        this.workDays = workDays;
    }

    public void setClassCode(int classCode) {
        this.classCode = classCode;
    }

    public int getClassCode() {
        return classCode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int computeClassCode(String str) {
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

    public List<WorkDay> computeWorkday(String str) {
        WorkDay[] days = new WorkDay[]{WorkDay.SUN, WorkDay.MON, WorkDay.THU, WorkDay.WED, WorkDay.THU, WorkDay.FRI, WorkDay.SAT};
        String[] daysStr = new String[]{"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        String[] tmp = str.split("-");
        int start = -1;
        int end = -1;
        for (int i = 0; i < 7; i++) {
            if (tmp[0].equals(daysStr[i]))
                start = i;
            if (tmp[1].equals(daysStr[i]))
                end = i;
        }
        return new ArrayList<>(Arrays.asList(days).subList(start, end + 1));
    }
}

enum WorkDay {
    SUN,    //星期日
    MON,    //星期一
    TUE,    //星期二
    WED,    //星期三
    THU,    //星期四
    FRI,    //星期五
    SAT     //星期六
}