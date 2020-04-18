package com.newer.controller;

import com.alibaba.fastjson.JSON;
import com.newer.entity.Score;
import com.newer.service.ScoreService;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
   // 添加学生
    @GetMapping("/insertScore.action")
    public Score insertScore(Score score){
        SimpleDateFormat df1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df1.format(new Date()));// new Date()为获取当前系统时间
        score.setUpdataDate(df1.format(new Date()));//修改时间
      Integer qin=  Integer.parseInt(score.getAttendanceRecord());//考勤
      Integer zuo=  Integer.parseInt(score.getAssignmentRecord());//作业
       Integer kao= Integer.parseInt(score.getExamRecond());//考试
       double sum= qin*0.3+zuo*0.3+kao*0.4;
       String str="";
        score.setTotalPoints(""+sum);
      return   this.scoreService.insert(score);
    }
    //添加学生和修改学生   注意 修改学生是根据id修改的
    //修改学生测试地址：http://localhost:8080/ScoreManagement_war_exploded/score/insertScore.action?id=11&&student.id=13&&teacher.id=1004&&course.id=2&&attendanceRecord=60&&assignmentRecord=70&&examRecond=80&&year=2019&&phases=1&&saveDate=2020&&updataDate=2020111
    //添加学生地址：http://localhost:8080/ScoreManagement_war_exploded/score/insertScore.action?student.id=16&&teacher.id=1004&&course.id=2&&attendanceRecord=60&&assignmentRecord=70&&examRecond=80&&year=2019&&phases=1&&saveDate=2020&&updataDate=2020111
    @GetMapping("/insertAndUpdateScore.action")
    public Score insertAndUpdateScore( Score score ,HttpServletRequest request){
       String studentId= request.getParameter("student.id");
        String courseId= request.getParameter("course.id");
        System.out.println(studentId);
        System.out.println(courseId);
        String s=null;
        try{
            int integer = this.scoreService.queryByStudentAndCouerse(Integer.parseInt(studentId),Integer.parseInt(courseId));
          s =Integer.toString(integer);
            System.out.println(integer+"sd");
            if (s!=null){
                System.out.println("进修改了");
                return this.scoreService.update(score);
            }
        }catch (NullPointerException n){
            System.out.println("进添加了");
            SimpleDateFormat df1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            System.out.println(df1.format(new Date()));// new Date()为获取当前系统时间
            score.setUpdataDate(df1.format(new Date()));//修改时间
            Integer qin=  Integer.parseInt(score.getAttendanceRecord());//考勤
            Integer zuo=  Integer.parseInt(score.getAssignmentRecord());//作业
            Integer kao= Integer.parseInt(score.getExamRecond());//考试
            double sum= qin*0.3+zuo*0.3+kao*0.4;
            String str="";
            score.setTotalPoints(""+sum);
            return this.scoreService.insert(score);
        }
        return  score;
    }
    //修改学生
    @GetMapping("/updateScore.action")
    public String updateScore(Score score){
        score=  this.scoreService.update(score);

        //判断对象是否为空
        if (score==null){
            score.setSuccess("false");
            return JSON.toJSONString(score);
        }else{

            score.setSuccess("ok");
            return JSON.toJSONString(score);
        }
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