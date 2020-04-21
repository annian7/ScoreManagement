package com.newer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.newer.entity.Course;
import com.newer.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Course)表控制层
 *
 * @author makejava
 * @since 2020-03-31 22:34:33
 */
@RestController
@RequestMapping("/course")
@CrossOrigin("*")
public class CourseController {
    /**
     * 服务对象
     */
    @Autowired
    private CourseService courseService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectCourseOne.action")
    public Course selectOne(int id) {
        return this.courseService.queryById(id);
    }

    @GetMapping("/queryAll.action")
    public String queryAll(){
        //将List集合转换为json对象返回
        //SerializerFeature.DisableCircularReferenceDetect 禁止循环引用，避免json出现"$ref":"$"的情况
        return  JSON.toJSONString(this.courseService.queryAll(), SerializerFeature.DisableCircularReferenceDetect);
    }

}