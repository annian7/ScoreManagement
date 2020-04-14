package com.newer.entity;


/**
 * (Course)课程
 *
 * @author makejava
 * @since 2020-03-31 22:34:33
 */
public class Course {
    
    private Integer id;
    
    private String name;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}