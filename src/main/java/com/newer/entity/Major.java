package com.newer.entity;


import org.springframework.beans.factory.annotation.Autowired;

/**
 * (Major)专业
 *
 * @author makejava
 * @since 2020-03-31 22:34:35
 */
public class Major {
    
    private int id;
    
    private String name;

    private College college;

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

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "Major{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", college=" + college +
                '}';
    }
}