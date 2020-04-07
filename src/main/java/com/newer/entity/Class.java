package com.newer.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * (Class)班级
 *
 * @author makejava
 * @since 2020-03-31 22:34:32
 */
public class Class {

    private int id;
    private Major major;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", majorId=" + major +
                '}';
    }
}