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
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Score> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param score 实例对象
     * @return 对象列表
     */
    List<Score> queryByIdAll(Score score);

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
    int update(Score score);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(int id);

    //按照班级 学期 课程名查询单个学生成绩
    Score queryStudentScore(@Param("id")Integer id,
                                  @Param("name")String name,
                                  @Param("phases")Integer phases);
    List<Score> queryClassById(@Param("classId") Integer classId);
}