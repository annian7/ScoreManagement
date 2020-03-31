package com.newer.service.impl;

import com.newer.entity.Class;
import com.newer.dao.ClassDao;
import com.newer.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Class)表服务实现类
 *
 * @author makejava
 * @since 2020-03-31 22:34:32
 */
@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassDao classDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Class queryById(int id) {
        return this.classDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Class> queryAllByLimit(int offset, int limit) {
        return this.classDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param shift 实例对象
     * @return 实例对象
     */
    @Override
    public Class insert(Class shift) {
        this.classDao.insert(shift);
        return shift;
    }

    /**
     * 修改数据
     *
     * @param shift 实例对象
     * @return 实例对象
     */
    @Override
    public Class update(Class shift) {
        this.classDao.update(shift);
        return this.queryById(shift.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(int id) {
        return this.classDao.deleteById(id) > 0;
    }
}