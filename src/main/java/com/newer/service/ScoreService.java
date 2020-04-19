package com.newer.service;

import com.newer.entity.Score;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Score)表服务接口
 *
 * @author makejava
 * @since 2020-03-31 22:34:36
 */
public interface ScoreService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Score queryById(int id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Score> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    Score insert(Score score);

    /**
     * 修改数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    Score update(Score score);

    List<Score> queryByIdAll(Score score);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(int id);

    List<Score> queryStudentScore(Integer id,Integer courseId,Integer phases);

    List<Score> queryClassById(Integer classId);

    Integer queryByStudentAndCouerse(@Param("studentId") Integer studentId,@Param("courseId") Integer courseId);
    //根级班级id，年份，学期查询所有学生成绩 queryStudentScoreAll
    List<Score> queryStudentScoreAll(@Param("classId") Integer classId,@Param("year")String year,@Param("phases") Integer phases,@Param("courseId") Integer courseId);
}