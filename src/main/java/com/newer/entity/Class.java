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
    @Autowired
    private Major majorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Major getMajorId() {
        return majorId;
    }

    public void setMajorId(Major majorId) {
        this.majorId = majorId;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", majorId=" + majorId +
                '}';
    }
}