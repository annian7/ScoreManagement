package com.newer.dao;

import com.newer.entity.Class;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Class)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-31 22:34:32
 */
public interface ClassDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Class queryById(int id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Class> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param shift 实例对象
     * @return 对象列表
     */
    List<Class> queryAll(Class shift);

    /**
     * 新增数据
     *
     * @param shift 实例对象
     * @return 影响行数
     */
    int insert(Class shift);

    /**
     * 修改数据
     *
     * @param shift 实例对象
     * @return 影响行数
     */
    int update(Class shift);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(int id);

}