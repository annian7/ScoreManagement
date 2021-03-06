package com.newer.entity;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
/**
 * (Score)数据传输对象
 *
 * @author makejava
 * @since 2020-03-31 22:34:36
 */

public class Score  {
    
    private Integer id;
    private Student student;
    private Teacher teacher;
    private Course course;
    private Class classId;
    private String attendanceRecord;
    
    private String assignmentRecord;
    
    private String examRecond;
    
    private String totalPoints;
    
    private String year;
    
    private Integer phases;
    private String success;
    private String saveDate;
    
    private String updataDate;

    public void setClassId(Class classId) {
        this.classId = classId;
    }

    public Class getClassId() {
        return classId;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    public String getAttendanceRecord() {
        return attendanceRecord;
    }

    public void setAttendanceRecord(String attendanceRecord) {
        this.attendanceRecord = attendanceRecord;
    }

    public String getAssignmentRecord() {
        return assignmentRecord;
    }

    public void setAssignmentRecord(String assignmentRecord) {
        this.assignmentRecord = assignmentRecord;
    }

    public String getExamRecond() {
        return examRecond;
    }

    public void setExamRecond(String examRecond) {
        this.examRecond = examRecond;
    }

    public String getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(String totalPoints) {
        this.totalPoints = totalPoints;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getPhases() {
        return phases;
    }

    public void setPhases(Integer phases) {
        this.phases = phases;
    }

    public String getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(String saveDate) {
        this.saveDate = saveDate;
    }

    public String getUpdataDate() {
        return updataDate;
    }

    public void setUpdataDate(String updataDate) {
        this.updataDate = updataDate;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", student=" + student +
                ", teacher=" + teacher +
                ", course=" + course +
                ", attendanceRecord='" + attendanceRecord + '\'' +
                ", assignmentRecord='" + assignmentRecord + '\'' +
                ", examRecond='" + examRecond + '\'' +
                ", totalPoints='" + totalPoints + '\'' +
                ", year='" + year + '\'' +
                ", phases=" + phases +
                ", success='" + success + '\'' +
                ", saveDate='" + saveDate + '\'' +
                ", updataDate='" + updataDate + '\'' +
                '}';
    }
}