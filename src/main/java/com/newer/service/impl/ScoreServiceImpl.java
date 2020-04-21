package com.newer.service.impl;

import com.newer.entity.Score;
import com.newer.dao.ScoreDao;
import com.newer.service.ScoreService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Score)表服务实现类
 *
 * @author makejava
 * @since 2020-03-31 22:34:36
 */
@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreDao scoreDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Score queryById(int id) {
        return this.scoreDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Score> queryAllByLimit(int offset, int limit) {
        return this.scoreDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Score> queryStudentScores(int studentId, int year, int phases) {
        return scoreDao.queryStudentScores(studentId, year, phases);
    }

    /**
     * 新增数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    @Override
    public Score insert(Score score) {
        this.scoreDao.insert(score);
        return score;
    }

    /**
     * 修改数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    @Override
    public Score update(Score score) {
        this.scoreDao.update(score);
        return this.queryById(score.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(int id) {
        return this.scoreDao.deleteById(id) > 0;
    }

    @Override
    public List<Score> queryStudentScore(Integer id, Integer courseId, Integer phases) {
        return this.scoreDao.queryStudentScore(id, courseId, phases);
    }

    @Override
    public List<Score> queryClassById(Integer classId) {
        return this.scoreDao.queryClassById(classId);
    }

    @Override
    public Integer queryByStudentAndCouerse(Integer studentId, Integer courseId) {
        return this.scoreDao.queryByStudentAndCouerse(studentId, courseId);
    }

    @Override
    public List<Score> queryStudentScoreAll(Integer classId, String year, Integer phases, Integer courseId) {
        return this.scoreDao.queryStudentScoreAll(classId, year, phases,courseId);
    }


}