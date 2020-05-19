package server.dao;

import server.entity.Ringinfo;

public interface RinginfoDao {
    int deleteByPrimaryKey(Integer ringId);

    int insert(Ringinfo record);

    int insertSelective(Ringinfo record);

    Ringinfo selectByPrimaryKey(Integer ringId);

    int updateByPrimaryKeySelective(Ringinfo record);

    int updateByPrimaryKey(Ringinfo record);
}