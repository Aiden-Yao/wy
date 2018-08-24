package entity;

import entity.base.Entity;

public class Mark extends Entity {
    private String stuId;
    private String stuName;
    private int dataStructure;
    private int math;
    private int English;
    private int computer;

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getDataStructure() {
        return dataStructure;
    }

    public void setDataStructure(int dataStructure) {
        this.dataStructure = dataStructure;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return English;
    }

    public void setEnglish(int english) {
        English = english;
    }

    public int getComputer() {
        return computer;
    }

    public void setComputer(int computer) {
        this.computer = computer;
    }

    @Override
    public String getTableName() {
        return "studentmark";
    }
}
