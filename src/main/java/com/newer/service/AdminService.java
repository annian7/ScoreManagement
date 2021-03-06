package com.newer.service;

import com.newer.entity.Admin;
import com.newer.entity.Student;
import com.newer.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Admin)表服务接口
 *
 * @author makejava
 * @since 2020-03-31 22:34:32
 */
public interface AdminService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Admin queryById(int id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Admin> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin insert(Admin admin);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin update(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(int id);
    //管理员登录
    Admin findAdminById(int id, String password);
    //添加学生
    int addStudent(Student student);
    //添加教师
    int addTeacher(Teacher teacher);
    //管理员重置密码
    int resetPassword(@Param("id")int id,@Param("password") String password);
}