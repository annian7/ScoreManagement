package com.newer.controller;

import com.alibaba.fastjson.JSON;
import com.newer.entity.Admin;
import com.newer.entity.Student;
import com.newer.entity.Teacher;
import com.newer.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2020-03-31 22:34:32
 */
@RestController
@RequestMapping(value = "/admin")
@CrossOrigin("*")
public class AdminController {
    /**
     * 服务对象
     */
    @Autowired
    private AdminService adminService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne.action")

    public Admin selectOne(int id) {
        return this.adminService.queryById(id);
    }
    @GetMapping("/login.action")
    //登录操作
    public Admin adminLogin(int id,String password ) {
        Admin admin= this.adminService.findAdminById(id,password);
        return admin;
    }
    @GetMapping("/addStudent.action")
//添加学生
    public int addStudent(Student student){
        int row=this.adminService.addStudent(student);
        return  row;
    }
    @GetMapping("/addTeacher.action")
//添加教师
    public int addTeacher(Teacher teacher){
      int row=this.adminService.addTeacher(teacher);
      return row;
    }

}