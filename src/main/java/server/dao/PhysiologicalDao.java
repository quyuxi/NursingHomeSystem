package server.dao;

import server.entity.Physiological;

public interface PhysiologicalDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Physiological record);

    int insertSelective(Physiological record);

    Physiological selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Physiological record);

    int updateByPrimaryKey(Physiological record);
}