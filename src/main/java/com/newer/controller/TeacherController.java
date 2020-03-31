package com.newer.controller;

import com.newer.entity.Teacher;
import com.newer.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Teacher)表控制层
 *
 * @author makejava
 * @since 2020-03-31 22:34:36
 */
@RestController
public class TeacherController {
    /**
     * 服务对象
     */
    @Autowired
    private TeacherService teacherService;

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

}