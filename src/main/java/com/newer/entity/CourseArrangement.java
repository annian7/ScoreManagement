package com.newer.entity;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * (CourseArrangement)课程安排
 *
 * @author makejava
 * @since 2020-03-31 22:34:33
 */
public class CourseArrangement {
    
    private int id;

    @Autowired
    private Teacher teacher;
    @Autowired
    private Course course;
    @Autowired
    private Class shift;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Class getShift() {
        return shift;
    }

    public void setShift(Class shift) {
        this.shift = shift;
    }

    @Override
    public String toString() {
        return "CourseArrangement{" +
                "id=" + id +
                ", teacher=" + teacher +
                ", course=" + course +
                ", shift=" + shift +
                '}';
    }
}