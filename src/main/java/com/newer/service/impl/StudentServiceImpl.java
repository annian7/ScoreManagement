package com.newer.service.impl;

import com.newer.entity.Student;
import com.newer.dao.StudentDao;
import com.newer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Student)表服务实现类
 *
 * @author makejava
 * @since 2020-03-31 22:34:36
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Student queryById(int id) {
        return this.studentDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Student> queryAllByLimit(int offset, int limit) {
        return this.studentDao.queryAllByLimit(offset, limit);
    }

    @Override
    public int queryCount() {
        return this.studentDao.queryCount();
    }

    /**
     * 查询所有学生信息
     * @param student
     * @return
     */

    @Override
    public List<Student> queryAll(Student student) {
        return studentDao.queryAll(student);
    }

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student insert(Student student) {
        this.studentDao.insert(student);
        return student;
    }

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student update(Student student) {
        this.studentDao.update(student);
        return this.queryById(student.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(int id) {
        return this.studentDao.deleteById(id) > 0;
    }
    //学生登录
    @Override
    public Student findStudentById(int id, String password) {
        return this.studentDao.findStudentById(id, password);
    }


    @Override
    public int resetPassword(int id, String password) {
        return this.studentDao.resetPassword(id, password);
    }


}