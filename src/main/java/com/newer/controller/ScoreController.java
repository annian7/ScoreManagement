package com.newer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.newer.entity.Class;
import com.newer.entity.Course;
import com.newer.entity.Score;
import com.newer.entity.Student;
import com.newer.entity.Teacher;
import com.newer.service.ScoreService;
import org.apache.http.HttpRequest;
import org.apache.ibatis.annotations.Param;
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

    //修改学生测试地址：http://localhost:8080/ScoreManagement_war_exploded/score/insertScore.action?id=11&&student.id=13&&teacher.id=1004&&course.id=2&&attendanceRecord=60&&assignmentRecord=70&&examRecond=80&&year=2019&&phases=1&&saveDate=2020&&updataDate=2020111
    //添加学生地址：http://localhost:8080/ScoreManagement_war_exploded/score/insertScore.action?student.id=16&&teacher.id=1004&&course.id=2&&attendanceRecord=60&&assignmentRecord=70&&examRecond=80&&year=2019&&phases=1&&saveDate=2020&&updataDate=2020111
    @GetMapping("/insertScore.action")
    public String insertScore(Score score, HttpServletRequest request) {
        String studentId = request.getParameter("studentId");
        String courseId = request.getParameter("courseId");
        String teacherId = request.getParameter("teacherId");
        String s = null;
        //根据课程id和学生id查成绩表中是否已有记录
        try {
            int integer = this.scoreService.queryByStudentAndCouerse(Integer.parseInt(studentId), Integer.parseInt(courseId));
            s = Integer.toString(integer);
            if (s != null) {
                score.setSuccess("false");
                return JSON.toJSONString(score);
            }
        } catch (NullPointerException n) {
            SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            score.setUpdataDate(df1.format(new Date()));//修改时间
            Integer qin = Integer.parseInt(score.getAttendanceRecord());//考勤
            Integer zuo = Integer.parseInt(score.getAssignmentRecord());//作业
            Integer kao = Integer.parseInt(score.getExamRecond());//考试
            //计算总分
            double sum = qin * 0.3 + zuo * 0.3 + kao * 0.4;
            Student student = new Student();
            Teacher teacher = new Teacher();
            Course course = new Course();
            Class shift = new Class();
            student.setId(Integer.parseInt(studentId));
            teacher.setId(Integer.parseInt(teacherId));
            course.setId(Integer.parseInt(courseId));
            score.setStudent(student);
            score.setTeacher(teacher);
            score.setCourse(course);
            score.setTotalPoints("" + sum);
            score.setSuccess("ok");
            return JSON.toJSONString(this.scoreService.insert(score));
        }
        return "score";
    }

    //根据班级id 年份 学期 课程id查询所有学生成绩
    @GetMapping("/queryStudentScoreAll.action")
    public List<Score> queryStudentScoreAll(Integer classId, String year, Integer phases, Integer courseId) {
        List<Score> list = this.scoreService.queryStudentScoreAll(classId, year, phases,courseId);
        System.out.println(list);
        return list;
    }

    //修改学生
    @GetMapping("/updateScore.action")
    public String updateScore(Score score) {
        score = this.scoreService.update(score);
        //判断对象是否为空
        if (score == null) {
            score.setSuccess("false");
            return JSON.toJSONString(score);
        } else {
            score.setSuccess("ok");
            return JSON.toJSONString(score);
        }
    }

    //根据学号，学年，学期查看学生成绩
    @GetMapping("/selectStudentScores.action")
    public String queryStudentScores(String studentId,String year,String phases){
        //将List集合转换为json对象返回
        //SerializerFeature.DisableCircularReferenceDetect 禁止循环引用，避免json出现"$ref":"$"的情况
        return  JSON.toJSONString(scoreService.queryStudentScores(Integer.parseInt(studentId), Integer.parseInt(year), Integer.parseInt(phases)),SerializerFeature.DisableCircularReferenceDetect);
    }

    //按班级id，课程id，学期查询该班级所有学生成绩
    @GetMapping("/queryStudentScore.action")
    public List<Score> queryStudentScore(Integer id, Integer courseId, Integer phases) {
        List<Score> list = this.scoreService.queryStudentScore(id, courseId, phases);
        return list;
    }

    //根据班级id查询所有学生成绩
    @GetMapping("/queryClassById.action")
    public List<Score> queryClassById(Integer classId) {
        List<Score> list = this.scoreService.queryClassById(classId);
        return list;
    }

}