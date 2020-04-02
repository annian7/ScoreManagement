package com.newer.controller;

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
    public Map<String,String> TeacherLogin(int id, String password ) {
        Teacher teacher = teacherService.findTeacherById(id, password);
        Map<String,String> map = new HashMap<>();
        //判断对象是否为空
        if (teacher==null){
            map.put("success", "false");
            return map;
        }else{
            try {
                //转换为map对象
                map = BeanUtils.describe(teacher);
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
}