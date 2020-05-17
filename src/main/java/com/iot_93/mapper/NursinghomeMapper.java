package com.iot_93.mapper;

import com.iot_93.entity.Nursinghome;
import com.iot_93.entity.NursinghomeKey;

public interface NursinghomeMapper {
    int deleteByPrimaryKey(NursinghomeKey key);

    int insert(Nursinghome record);

    int insertSelective(Nursinghome record);

    Nursinghome selectByPrimaryKey(NursinghomeKey key);

    int updateByPrimaryKeySelective(Nursinghome record);

    int updateByPrimaryKey(Nursinghome record);
}