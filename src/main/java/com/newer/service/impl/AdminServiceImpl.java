package com.newer.service.impl;

import com.newer.entity.Admin;
import com.newer.dao.AdminDao;
import com.newer.entity.Student;
import com.newer.entity.Teacher;
import com.newer.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Admin)表服务实现类
 *
 * @author makejava
 * @since 2020-03-31 22:34:32
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Admin queryById(int id) {
        return this.adminDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Admin> queryAllByLimit(int offset, int limit) {
        return this.adminDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin insert(Admin admin) {
        this.adminDao.insert(admin);
        return admin;
    }

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin update(Admin admin) {
        this.adminDao.update(admin);
        return this.queryById(admin.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(int id) {
        return this.adminDao.deleteById(id) > 0;
    }

    @Override
    public Admin findAdminById(int id, String password) {
        return this.adminDao.findAdminById(id, password);
    }

    @Override
    public int addStudent(Student student) {
        return this.adminDao.addStudent(student);
    }

    @Override
    public int addTeacher(Teacher teacher) {
        return this.adminDao.addTeacher(teacher);
    }

    @Override
    public int resetPassword(int id, String password) {
        return this.adminDao.resetPassword(id, password);
    }


}