package com.newer.entity;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * (Student)数据传输对象
 *
 * @author makejava
 * @since 2020-03-31 22:34:36
 */

public class Student {

    private int id;

    private String password;

    private String name;

    private String sex;

    private String birthday;

    private String tel;

    private String email;

    private Class shift;

    private String success;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Object getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Class getShift() {
        return shift;
    }

    public void setShift(Class shift) {
        this.shift = shift;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", shift=" + shift +
                '}';
    }
}