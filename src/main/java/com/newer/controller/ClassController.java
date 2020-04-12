package com.newer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.newer.entity.Class;
import com.newer.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Class)表控制层
 *
 * @author makejava
 * @since 2020-03-31 22:34:32
 */
@RestController
@RequestMapping("/class")
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

    /**
     * 查询所有班级
     * @return
     */
    @GetMapping("/queryAll.action")
    public String selectAll(){
        //将对象转换为json对象返回
        //SerializerFeature.DisableCircularReferenceDetect 禁止循环引用，避免json出现"$ref":"$"的情况
        return JSON.toJSONString(this.classService.queryAll(), SerializerFeature.DisableCircularReferenceDetect);
    }
}