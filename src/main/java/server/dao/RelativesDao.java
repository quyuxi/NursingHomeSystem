package server.dao;


import server.pojo.Relative;

public interface RelativesDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Relative record);

    int insertSelective(Relative record);

    Relative selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Relative record);

    int updateByPrimaryKey(Relative record);
}