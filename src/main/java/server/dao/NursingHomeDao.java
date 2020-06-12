package server.dao;


import server.pojo.NursingHome;

public interface NursingHomeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(NursingHome record);

    int insertSelective(NursingHome record);

    NursingHome selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NursingHome record);

    int updateByPrimaryKey(NursingHome record);
}