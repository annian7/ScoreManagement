package com.newer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.newer.entity.CourseArrangement;
import com.newer.service.CourseArrangementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (CourseArrangement)表控制层
 *
 * @author makejava
 * @since 2020-03-31 22:34:33
 */
@RestController
@RequestMapping("/courseArrangement")
@CrossOrigin("*")
public class CourseArrangementController {
    /**
     * 服务对象
     */
    @Autowired
    private CourseArrangementService courseArrangementService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectCourseArrangementOne.action")
    public CourseArrangement selectOne(int id) {
        return this.courseArrangementService.queryById(id);
    }

    @GetMapping("/queryById.action")
    public  CourseArrangement queryById(int id ){
        return  this.courseArrangementService.queryById(id);
    }

    //根据条件查询，若无条件则查询所有
    @GetMapping("/queryAll.action")
    public String queryAll(String teacherId,String courseId,String classId){
        List<CourseArrangement> courseArrangements = courseArrangementService.queryAll(teacherId, courseId, classId);
        //将对象转换为json对象返回
        //SerializerFeature.DisableCircularReferenceDetect 禁止循环引用，避免json出现"$ref":"$"的情况
        return  JSON.toJSONString(courseArrangements, SerializerFeature.DisableCircularReferenceDetect);
    }

}