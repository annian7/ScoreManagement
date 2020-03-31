package com.newer.service;

import com.newer.entity.Major;
import java.util.List;

/**
 * (Major)表服务接口
 *
 * @author makejava
 * @since 2020-03-31 22:34:33
 */
public interface MajorService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Major queryById(int id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Major> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param major 实例对象
     * @return 实例对象
     */
    Major insert(Major major);

    /**
     * 修改数据
     *
     * @param major 实例对象
     * @return 实例对象
     */
    Major update(Major major);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(int id);

}