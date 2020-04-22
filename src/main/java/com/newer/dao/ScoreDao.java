package com.newer.dao;

import com.newer.entity.Score;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Score)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-31 22:34:35
 */
public interface ScoreDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Score queryById(int id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Score> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 根据学号 学年 学期查看成绩
     * @param studentId
     * @param year
     * @param phases
     * @return
     */
    List<Score> queryStudentScores(@Param("studentId") int studentId,@Param("year") int year,@Param("phases") int phases);

    /**
     * 新增数据
     *
     * @param score 实例对象
     * @return 影响行数
     */
    int insert(Score score);

    /**
     * 修改数据
     *
     * @param score 实例对象
     * @return 影响行数
     */
    //添加学生成绩
    int update(Score score);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(int id);

    //按照班级 学期 课程名查询单个学生成绩
    List<Score> queryStudentScore(@Param("id") Integer id,
                                  @Param("courseId") Integer courseId,
                                  @Param("phases") Integer phases);

    //根据班级id查询所有学生成绩
    List<Score> queryClassById(@Param("classId") Integer classId);

    //查询成绩表中学生的id和课程的id
    Integer queryByStudentAndCouerse(@Param("studentId") Integer studentId, @Param("courseId") Integer courseId);

    //根级班级id，年份，学期查询所有学生成绩 queryStudentScoreAll
    List<Score> queryStudentScoreAll(@Param("classId") Integer classId, @Param("year") String year, @Param("phases") Integer phases, @Param("courseId") Integer courseId);
}