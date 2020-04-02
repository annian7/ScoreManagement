package com.newer.controller;

import com.newer.entity.Score;
import com.newer.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (Score)表控制层
 *
 * @author makejava
 * @since 2020-03-31 22:34:36
 */
@RestController
@RequestMapping("/score")
@CrossOrigin("*")
public class ScoreController {
    /**
     * 服务对象
     */
    @Autowired
    private ScoreService scoreService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectScoreOne.action")
    public Score selectOne(int id) {
        return this.scoreService.queryById(id);
    }

}