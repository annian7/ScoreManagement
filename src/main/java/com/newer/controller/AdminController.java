package com.newer.controller;

import com.alibaba.fastjson.JSON;
import com.newer.entity.Admin;
import com.newer.entity.Student;
import com.newer.entity.Teacher;
import com.newer.service.AdminService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    public Map addStudent(Student student) {
        Map map = new HashMap();
        int row = this.adminService.addStudent(student);
        map.put("result",row);
        return map;
    }

    @GetMapping("/addTeacher.action")
    //添加教师
    public Map addTeacher(Teacher teacher) {
        Map map = new HashMap();
        int row = this.adminService.addTeacher(teacher);
        map.put("result",row);
        return map;
    }
    @PostMapping("/update.action")
    public Admin updateAdminInfo(Admin admin){
       return adminService.update(admin);
    }

}