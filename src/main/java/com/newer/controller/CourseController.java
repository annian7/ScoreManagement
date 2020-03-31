package com.newer.controller;

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

}