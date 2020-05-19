package server.dao;

import server.entity.Ringkeyinfo;

public interface RingkeyinfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Ringkeyinfo record);

    int insertSelective(Ringkeyinfo record);

    Ringkeyinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ringkeyinfo record);

    int updateByPrimaryKey(Ringkeyinfo record);
}