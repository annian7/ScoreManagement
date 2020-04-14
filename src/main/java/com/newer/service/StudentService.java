package com.newer.service;

import com.newer.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Student)表服务接口
 *
 * @author makejava
 * @since 2020-03-31 22:34:36
 */
public interface StudentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Student queryById(int id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Student> queryAllByLimit(int offset, int limit,Integer id);

    /**
     * 查询总行数
     *
     * @return
     */
    int queryCount();

    List<Student> queryAll(Student student);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student insert(Student student);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student update(Student student);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(int id);
    //学生登录
    Student findStudentById(int id, String password);
    //学生重置密码
    int resetPassword(int id, String password);
}