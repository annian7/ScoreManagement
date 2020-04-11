package com.newer.controller;

import com.alibaba.fastjson.JSON;
import com.newer.entity.*;
import com.newer.entity.Class;
import com.newer.service.AdminService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

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

    private Logger log = LogManager.getLogger(AdminController.class);

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
    public Map<String,String> adminLogin(int id, String password) {
        Admin admin = this.adminService.findAdminById(id, password);
        Map<String,String> map = new HashMap<>();
        //判断对象是否为空
        if (admin==null){
            map.put("success", "false");
            return map;
        }else{
            try {
                //admin对象转换为map对象
                map = BeanUtils.describe(admin);
                map.put("success","ok");
            } catch (IllegalAccessException e) {
                log.error(e.getMessage());
            } catch (InvocationTargetException e) {
                log.error(e.getMessage());
            } catch (NoSuchMethodException e) {
                log.error(e.getMessage());
            }
            return map;
        }
    }

    @GetMapping("/addStudent.action")
    //添加学生
    public Map addStudent(Student student,Integer classId) {
        Map map = new HashMap();
        Class cl=new Class();
        cl.setId(classId);
        student.setShift(cl);
        int row = this.adminService.addStudent(student);
        map.put("result",row);
        return map;
    }

    @GetMapping("/addTeacher.action")
    //添加教师
    public Map addTeacher(Teacher teacher,Integer collegeId) {
        Map map = new HashMap();
        College cl=new College();
        cl.setId(collegeId);
        teacher.setCollege(cl);
        int row = this.adminService.addTeacher(teacher);
        map.put("result",row);
        return map;
    }
    @PostMapping("/update.action")
    public Admin updateAdminInfo(Admin admin){
       return adminService.update(admin);
    }
    //管理员修改个人密码
    @GetMapping("/updatePassword.action")
    public  String updatePassword(Admin admin){
        admin=  this.adminService.update(admin);
        //判断对象是否为空

        if (admin==null){
            admin.setSuccess("false");
            return JSON.toJSONString(admin);
        }else{
            admin.setSuccess("ok");
            return JSON.toJSONString(admin);
        }

    }
    //学生重置个人密码
    @GetMapping("/resetPassword.action")
    public  Map resetPassword( int id, String password){
        Map map= new HashMap();
        int row =this.adminService.resetPassword(id, password);
        map.put("result",row);
        return  map;
    }
}