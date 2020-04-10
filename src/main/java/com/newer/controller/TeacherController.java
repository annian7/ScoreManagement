package com.newer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.newer.entity.Class;
import com.newer.entity.College;
import com.newer.entity.Student;
import com.newer.entity.Teacher;
import com.newer.service.TeacherService;
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
 * (Teacher)表控制层
 *
 * @author makejava
 * @since 2020-03-31 22:34:36
 */
@RestController
@RequestMapping("/teacher")
@CrossOrigin("*")
public class TeacherController {
    /**
     * 服务对象
     */
    @Autowired
    private TeacherService teacherService;
    private Logger log = LogManager.getLogger(TeacherController.class);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectTeacherOne.action")
    public Teacher selectOne(int id) {
        return this.teacherService.queryById(id);
    }
    //教师登录操作
    @GetMapping("/login.action")
    public String TeacherLogin(int id, String password ) {
        Teacher teacher = teacherService.findTeacherById(id, password);
        //判断对象是否为空
        if (teacher==null){
            teacher.setSuccess("false");
            return JSON.toJSONString(teacher);
        }else{
            teacher.setSuccess("ok");
            return JSON.toJSONString(teacher);
        }
    }

    @PostMapping("/update.action")
    public Teacher updata(Teacher tacher){
        return this.teacherService.update(tacher);
    }
    //教师修改个人密码
    @GetMapping("/updatePassword.action")
    public  String updatePassword(Teacher teacher){
        teacher=  this.teacherService.update(teacher);
        //判断对象是否为空
        if (teacher==null){
            teacher.setSuccess("false");
            return JSON.toJSONString(teacher);
        }else{
            teacher.setSuccess("ok");
            return JSON.toJSONString(teacher);
        }


    }

    //教师重置个人密码
    @GetMapping("/resetPassword.action")
    public  Map resetPassword( int id, String password){
        Map map= new HashMap();
        int row =this.teacherService.resetPassword(id, password);
        map.put("result",row);
        return  map;
    }

    @GetMapping("/queryAll.action")
    public String selectAll(Teacher teacher,String collegeId){
        College college = null;
        if(collegeId!=null&&!collegeId.equals("")){
            System.out.println("2");
            college = new College();
            college.setId(Integer.parseInt(collegeId));
        }
        //将对象转换为json对象返回
        //SerializerFeature.DisableCircularReferenceDetect 禁止循环引用，避免json出现"$ref":"$"的情况
        return  JSON.toJSONString(teacherService.queryAll(teacher), SerializerFeature.DisableCircularReferenceDetect);
    }
}