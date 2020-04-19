package com.newer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.newer.entity.Class;
import com.newer.entity.Student;
import com.newer.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Student)表控制层
 *
 * @author makejava
 * @since 2020-03-31 22:34:36
 */
@RestController
@RequestMapping("/student")
//设置允许跨域
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
    public String StudentLogin(int id, String password ) {
        Student student = studentService.findStudentById(id, password);
        //判断对象是否为空
        if (student==null){
            return "{\"success\":\"false\"}";
        }else{
            student.setSuccess("ok");
            return JSON.toJSONString(student);
        }
    }
    //修改学生信息
    @PostMapping("/update.action")
    public Student updata(Student student ){
        return studentService.update(student);
    }

    //查询所有学生
    @GetMapping("/queryAll.action")
    public String selectStudents(Student student,String classId){
        Class shift = null;
        if(classId!=null&&!classId.equals("")){
            shift = new Class();
            shift.setId(Integer.parseInt(classId));
            student.setShift(shift);
        }
        //将对象转换为json对象返回
        //SerializerFeature.DisableCircularReferenceDetect 禁止循环引用，避免json出现"$ref":"$"的情况
      return  JSON.toJSONString(studentService.queryAll(student), SerializerFeature.DisableCircularReferenceDetect);
    }


//学生修改密码
    @GetMapping("/updatePassword.action")
    public  String updatePassword(Student student){
        student=  this.studentService.update(student);

        //判断对象是否为空
        if (student==null){
            student.setSuccess("false");
            return JSON.toJSONString(student);
        }else{

            student.setSuccess("ok");
            return JSON.toJSONString(student);
        }


    }
    //学生重置个人密码
    @GetMapping("/resetPassword.action")
    public Map resetPassword(int id, String password){
        Map map= new HashMap();
        int row =this.studentService.resetPassword(id, password);
        map.put("result",row);
        return  map;
    }
    //分页查询
    @GetMapping("/queryPage.action")
    public String selectPage(int page, int limit,Integer id){
        int offset = (page-1)*limit;
        int count =studentService.queryCount();
        //将对象转换为json对象返回
        //SerializerFeature.DisableCircularReferenceDetect 禁止循环引用，避免json出现"$ref":"$"的情况
        String students = JSON.toJSONString(studentService.queryAllByLimit(offset, limit,id), SerializerFeature.DisableCircularReferenceDetect);
        String json ="{\"count\":"+count+",\"data\":"+students+"}";
        return  json;
    }
    //删除学生信息
    @GetMapping("/deleteStudent.action")
    public boolean deleteStudent(Integer id){
        return this.studentService.deleteById(id);
    }
}