package com.newer.service;

import com.newer.entity.CourseArrangement;
import java.util.List;

/**
 * (CourseArrangement)表服务接口
 *
 * @author makejava
 * @since 2020-03-31 22:34:33
 */
public interface CourseArrangementService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CourseArrangement queryById(int id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CourseArrangement> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param courseArrangement 实例对象
     * @return 实例对象
     */
    CourseArrangement insert(CourseArrangement courseArrangement);

    /**
     * 修改数据
     *
     * @param courseArrangement 实例对象
     * @return 实例对象
     */
    CourseArrangement update(CourseArrangement courseArrangement);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(int id);

}