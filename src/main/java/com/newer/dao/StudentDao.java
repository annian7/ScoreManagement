package com.newer.dao;

import com.newer.entity.Admin;
import com.newer.entity.Student;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Student)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-31 22:34:36
 */
public interface StudentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Student queryById(int id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Student> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param student 实例对象
     * @return 对象列表
     */
    List<Student> queryAll(Student student);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int insert(Student student);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int update(Student student);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(int id);
    //学生登录操作
    Student findStudentById(@Param("id")int id, @Param("password")String password);
}