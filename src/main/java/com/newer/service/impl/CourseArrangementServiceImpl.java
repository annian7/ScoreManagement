package com.newer.service.impl;

import com.newer.entity.CourseArrangement;
import com.newer.dao.CourseArrangementDao;
import com.newer.service.CourseArrangementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CourseArrangement)表服务实现类
 *
 * @author makejava
 * @since 2020-03-31 22:34:33
 */
@Service
public class CourseArrangementServiceImpl implements CourseArrangementService {
    @Autowired
    private CourseArrangementDao courseArrangementDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CourseArrangement queryById(Integer id) {
        System.out.println("111112222");
        return this.courseArrangementDao.queryById(id);
    }


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<CourseArrangement> queryAllByLimit(int offset, int limit) {
        return this.courseArrangementDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<CourseArrangement> queryAll(String teacherId,String courseId,String classId) {
        return courseArrangementDao.queryAll(teacherId,courseId,classId);
    }

    /**
     * 新增数据
     *
     * @param courseArrangement 实例对象
     * @return 实例对象
     */
    @Override
    public CourseArrangement insert(CourseArrangement courseArrangement) {
        this.courseArrangementDao.insert(courseArrangement);
        return courseArrangement;
    }

    /**
     * 修改数据
     *
     * @param courseArrangement 实例对象
     * @return 实例对象
     */
    @Override
    public CourseArrangement update(CourseArrangement courseArrangement) {
        this.courseArrangementDao.update(courseArrangement);
        return this.queryById(courseArrangement.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(int id) {
        return this.courseArrangementDao.deleteById(id) > 0;
    }
}