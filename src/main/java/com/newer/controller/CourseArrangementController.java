package com.newer.controller;

import com.newer.entity.CourseArrangement;
import com.newer.service.CourseArrangementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (CourseArrangement)表控制层
 *
 * @author makejava
 * @since 2020-03-31 22:34:33
 */
@RestController
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

}