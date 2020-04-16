package com.newer.dao;

import com.newer.entity.CourseArrangement;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (CourseArrangement)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-31 22:34:33
 */
public interface CourseArrangementDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CourseArrangement queryById(@Param("id")Integer id);


    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CourseArrangement> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param
     * @return 对象列表
     */
    List<CourseArrangement> queryAll(@Param("teacherId") String teacherId,@Param("courseId") String courseId,@Param("classId") String classId);

    /**
     * 新增数据
     *
     * @param courseArrangement 实例对象
     * @return 影响行数
     */
    int insert(CourseArrangement courseArrangement);

    /**
     * 修改数据
     *
     * @param courseArrangement 实例对象
     * @return 影响行数
     */
    int update(CourseArrangement courseArrangement);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(int id);

}