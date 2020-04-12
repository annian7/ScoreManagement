package com.newer.service;

import com.newer.entity.Class;
import java.util.List;

/**
 * (Class)表服务接口
 *
 * @author makejava
 * @since 2020-03-31 22:34:32
 */
public interface ClassService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Class queryById(int id);

    List<Class> queryAll();

    /**
     * 新增数据
     *
     * @param shift 实例对象
     * @return 实例对象
     */
    Class insert(Class shift);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(int id);

}