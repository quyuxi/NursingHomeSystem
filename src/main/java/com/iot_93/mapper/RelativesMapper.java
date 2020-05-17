package com.iot_93.mapper;

import com.iot_93.entity.Relatives;
import com.iot_93.entity.RelativesKey;

public interface RelativesMapper {
    int deleteByPrimaryKey(RelativesKey key);

    int insert(Relatives record);

    int insertSelective(Relatives record);

    Relatives selectByPrimaryKey(RelativesKey key);

    int updateByPrimaryKeySelective(Relatives record);

    int updateByPrimaryKey(Relatives record);
}