package com.newer.service;

import com.newer.entity.Student;
import com.newer.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Teacher)表服务接口
 *
 * @author makejava
 * @since 2020-03-31 22:34:36
 */
public interface TeacherService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Teacher queryById(int id);

    /**
     * 分页查询
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Teacher>queryAllByLimit(int offset, int limit,Integer id);

    /**
     * 查询总行数
     * @return
     */
    int queryCount();
    /**
     * 新增数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    Teacher insert(Teacher teacher);

    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    Teacher update(Teacher teacher);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(int id);
    //教师登录
    Teacher findTeacherById( int id, String password);

    //教师重置密码
    int resetPassword(int id, String password);
}