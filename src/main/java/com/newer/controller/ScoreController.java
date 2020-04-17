package com.newer.controller;

import com.newer.entity.Score;
import com.newer.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @GetMapping("/insertScore.action")
    public Score insertScore(Score score){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        score.setUpdataDate(df.format(new Date()));
      return   this.scoreService.insert(score);
    }
    //测试查询所有
        @GetMapping("/queryByIdAll.action")
        public List<Score> queryByIdAll(Score score){
        return this.scoreService.queryByIdAll(score);
        }
        //按班级号，课程名，学期查询学生成绩
    @GetMapping("/queryStudentScore.action")
    public Score queryStudentScore(Integer id,String name,Integer phases){
        Score score=this.scoreService.queryStudentScore(id, name, phases);
      return   score;
    }
    //根据班级id查询所有学生成绩
    @GetMapping("/queryClassById.action")
    public List<Score> queryClassById(Integer classId){
        List<Score> list=this.scoreService.queryClassById(classId);
        return list;
    }
}