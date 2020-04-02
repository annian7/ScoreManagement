package com.newer.controller;

import com.newer.entity.Major;
import com.newer.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Major)表控制层
 *
 * @author makejava
 * @since 2020-03-31 22:34:33
 */
@RestController
@RequestMapping("/major")
@CrossOrigin("*")
public class MajorController {
    /**
     * 服务对象
     */
    @Autowired
    private MajorService majorService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectMajorOne.action")
    public Major selectOne(int id) {
        return this.majorService.queryById(id);
    }

}