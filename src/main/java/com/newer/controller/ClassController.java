package com.newer.controller;

import com.newer.entity.Class;
import com.newer.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Class)表控制层
 *
 * @author makejava
 * @since 2020-03-31 22:34:32
 */
@RestController
@CrossOrigin("*")
public class ClassController {
    /**
     * 服务对象
     */
    @Autowired
    private ClassService classService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectClassOne.action")
    public Class selectOne(int id) {
        return this.classService.queryById(id);
    }

}