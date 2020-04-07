package com.newer.controller;

import com.newer.entity.Admin;
import com.newer.entity.Student;
import com.newer.service.StudentService;
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

    private Logger log = LogManager.getLogger(StudentController.class);

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
    public Map StudentLogin(int id, String password ) {
        Student student = studentService.findStudentById(id, password);
        Map<String,String> map = new HashMap<>();
        //判断对象是否为空
        if (student==null){
            map.put("success", "false");
            return map;
        }else{
            try {
                //将对象转换为map对象
                map = BeanUtils.describe(student);
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


    //学生修改个人密码
    @GetMapping("/updatePassword.action")
    public  Map updatePassword(Student student){
          student=  this.studentService.update(student);
        Map<String,String> map = new HashMap<>();
        //判断对象是否为空
        if (student==null){
            map.put("success", "false");
            return map;
        }else{
            try {
                //将对象转换为map对象
                map = BeanUtils.describe(student);
                map.put("success","ok");
            } catch (IllegalAccessException e) {
                log.error(e.getMessage());
            } catch (InvocationTargetException e) {
                log.error(e.getMessage());
            } catch (NoSuchMethodException e) {
                log.error(e.getMessage());
            }

        }
        return  map;

    }
    //学生重置个人密码
    @GetMapping("/resetPassword.action")
    public  Map resetPassword( int id, String password){
        Map map= new HashMap();
        int row =this.studentService.resetPassword(id, password);
        map.put("result",row);
        return  map;
    }
}