package com.newer.service.impl;

import com.newer.entity.Major;
import com.newer.dao.MajorDao;
import com.newer.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Major)表服务实现类
 *
 * @author makejava
 * @since 2020-03-31 22:34:33
 */
@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorDao majorDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Major queryById(int id) {
        return this.majorDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Major> queryAllByLimit(int offset, int limit) {
        return this.majorDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param major 实例对象
     * @return 实例对象
     */
    @Override
    public Major insert(Major major) {
        this.majorDao.insert(major);
        return major;
    }

    /**
     * 修改数据
     *
     * @param major 实例对象
     * @return 实例对象
     */
    @Override
    public Major update(Major major) {
        this.majorDao.update(major);
        return this.queryById(major.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(int id) {
        return this.majorDao.deleteById(id) > 0;
    }
}