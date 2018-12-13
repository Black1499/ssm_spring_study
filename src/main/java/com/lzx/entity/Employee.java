package com.lzx.entity;

public class Employee {
    int id;
    String name;
    String sex;
    String education;
    String BigDecimal;

    public Employee(int id, String name, String sex, String education, String bigDecimal) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.education = education;
        BigDecimal = bigDecimal;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getBigDecimal() {
        return BigDecimal;
    }

    public void setBigDecimal(String bigDecimal) {
        BigDecimal = bigDecimal;
    }
}
