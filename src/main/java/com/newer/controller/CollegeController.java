package com.newer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.newer.entity.College;
import com.newer.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (College)表控制层
 *
 * @author makejava
 * @since 2020-03-31 22:34:33
 */
@RestController
@RequestMapping("/college")
@CrossOrigin("*")
public class CollegeController {
    /**
     * 服务对象
     */
    @Autowired
    private CollegeService collegeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectCollegeOne.action")
    public College selectOne(int id) {
        return this.collegeService.queryById(id);
    }

    @GetMapping("/queryAll.action")
    public String selectAll(){
        //将对象转换为json对象返回
        //SerializerFeature.DisableCircularReferenceDetect 禁止循环引用，避免json出现"$ref":"$"的情况
        return JSON.toJSONString(collegeService.queryAll(), SerializerFeature.DisableCircularReferenceDetect);
    }

}