package com.newer.controller;

import com.newer.entity.Admin;
import com.newer.entity.Student;
import com.newer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Student)表控制层
 *
 * @author makejava
 * @since 2020-03-31 22:34:36
 */
@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {
    /**
     * 服务对象
     */
    @Autowired
    private StudentService studentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectStudentOne.action")
    public Student selectOne(int id) {
        return this.studentService.queryById(id);
    }

    //学生登录操作
    @GetMapping("/login.action")
    public Student StudentLogin(int id, String password ) {
       return studentService.findStudentById(id, password);
    }
}