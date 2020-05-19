package server.dao;

import server.entity.Posture;

public interface PostureDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Posture record);

    int insertSelective(Posture record);

    Posture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Posture record);

    int updateByPrimaryKey(Posture record);
}