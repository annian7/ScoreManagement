package com.newer.controller;

import com.newer.entity.Admin;
import com.newer.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2020-03-31 22:34:32
 */
@RestController
public class AdminController {
    /**
     * 服务对象
     */
    @Autowired
    private AdminService adminService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne.action")
    public Admin selectOne(int id) {
        return this.adminService.queryById(id);
    }

    @RequestMapping(value = "aaa.action")
    public String test(){
        return "OK";
    }

}