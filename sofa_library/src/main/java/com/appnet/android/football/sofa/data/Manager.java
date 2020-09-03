package com.appnet.android.football.sofa.data;


import java.util.Calendar;
import java.util.List;

public class Manager extends Person {
    private Team team;
    private String nationality;
    private long dateOfBirthTimestamp;
    private String flag;
    private GeneralInfo generalInfo;
    private ManagerPerformance performance;
    private List<ManagerCareer> careerHistory;
    private transient int age = 0;

    public Team getTeam() {
        return team;
    }

    public String getNationality() {
        return nationality;
    }

    public long getDateOfBirthTimestamp() {
        return dateOfBirthTimestamp*1000;
    }

    public String getFlag() {
        return flag;
    }

    public int getAge() {
        if(age == 0) {
            long birthday = dateOfBirthTimestamp * 1000;
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(birthday);
            age = Calendar.getInstance().get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
        }
        return age;
    }

    public GeneralInfo getGeneralInfo() {
        return generalInfo;
    }

    public ManagerPerformance getPerformance() {
        return performance;
    }

    public List<ManagerCareer> getCareerHistory() {
        return careerHistory;
    }
}
