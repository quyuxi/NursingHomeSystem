package server.dao;

import server.entity.Elder;
import server.entity.ElderKey;

public interface ElderDao {
    int deleteByPrimaryKey(ElderKey key);

    int insert(Elder record);

    int insertSelective(Elder record);

    Elder selectByPrimaryKey(ElderKey key);

    int updateByPrimaryKeySelective(Elder record);

    int updateByPrimaryKey(Elder record);
}