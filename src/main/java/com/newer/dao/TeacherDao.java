package com.newer.dao;

import com.newer.entity.Student;
import com.newer.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Teacher)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-31 22:34:36
 */
public interface TeacherDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Teacher queryById(int id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Teacher> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,@Param("id") Integer id);

    /**
     * 查询总行数
     *S
     * @return
     */
    int queryCount();
    /**
     * 通过实体作为筛选条件查询
     *
     * @param teacher 实例对象
     * @return 对象列表
     */
    List<Teacher> queryAll(Teacher teacher);

    /**
     * 新增数据
     *
     * @param teacher 实例对象
     * @return 影响行数
     */
    int insert(Teacher teacher);

    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 影响行数
     */
    int update(Teacher teacher);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(int id);
    //教师登录操作
    Teacher findTeacherById(@Param("id") int id,@Param("password") String password);
    //教师修改密码
    int updatePassword(@Param("id")int id,@Param("password") String password);
    //教师重置密码
    int resetPassword(@Param("id")int id,@Param("password") String password);
}