package com.newer.service.impl;

import com.newer.entity.College;
import com.newer.dao.CollegeDao;
import com.newer.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (College)表服务实现类
 *
 * @author makejava
 * @since 2020-03-31 22:34:32
 */
@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeDao collegeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public College queryById(int id) {
        return this.collegeDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<College> queryAllByLimit(int offset, int limit) {
        return this.collegeDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<College> queryAll() {
        return collegeDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param college 实例对象
     * @return 实例对象
     */
    @Override
    public College insert(College college) {
        this.collegeDao.insert(college);
        return college;
    }

    /**
     * 修改数据
     *
     * @param college 实例对象
     * @return 实例对象
     */
    @Override
    public College update(College college) {
        this.collegeDao.update(college);
        return this.queryById(college.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(int id) {
        return this.collegeDao.deleteById(id) > 0;
    }
}