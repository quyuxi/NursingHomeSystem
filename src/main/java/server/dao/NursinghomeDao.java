package server.dao;

import server.entity.Nursinghome;

public interface NursinghomeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Nursinghome record);

    int insertSelective(Nursinghome record);

    Nursinghome selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Nursinghome record);

    int updateByPrimaryKey(Nursinghome record);
}