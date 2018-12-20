package com.lzx.entity;

import java.math.BigDecimal;

public class Employee {
    String id;
    String name;
    String sex;
    String education;
    BigDecimal salary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Employee() {
    }

    public Employee(String id, String name, String sex, String education, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.education = education;
        this.salary = salary;
    }
}
