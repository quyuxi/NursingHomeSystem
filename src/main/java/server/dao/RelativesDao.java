package server.dao;

import server.pojo.Relatives;

public interface RelativesDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Relatives record);

    int insertSelective(Relatives record);

    Relatives selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Relatives record);

    int updateByPrimaryKey(Relatives record);
}