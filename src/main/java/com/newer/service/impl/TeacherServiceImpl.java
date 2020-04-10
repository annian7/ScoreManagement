package com.newer.service.impl;

import com.newer.entity.Teacher;
import com.newer.dao.TeacherDao;
import com.newer.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.JstlUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Teacher)表服务实现类
 *
 * @author makejava
 * @since 2020-03-31 22:34:36
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Teacher queryById(int id) {
        return this.teacherDao.queryById(id);
    }

    @Override
    public List<Teacher> queryAll(Teacher teacher) {
        return teacherDao.queryAll(teacher);
    }


    /**
     * 新增数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    @Override
    public Teacher insert(Teacher teacher) {
        this.teacherDao.insert(teacher);
        return teacher;
    }

    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    @Override
    public Teacher update(Teacher teacher) {
        this.teacherDao.update(teacher);
        return this.queryById(teacher.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(int id) {
        return this.teacherDao.deleteById(id) > 0;
    }

    @Override
    public Teacher findTeacherById(int id, String password) {
        return this.teacherDao.findTeacherById(id,password);
    }
}