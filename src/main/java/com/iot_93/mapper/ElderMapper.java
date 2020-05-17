package com.iot_93.mapper;

import com.iot_93.entity.Elder;
import com.iot_93.entity.ElderKey;

public interface ElderMapper {
    int deleteByPrimaryKey(ElderKey key);

    int insert(Elder record);

    int insertSelective(Elder record);

    Elder selectByPrimaryKey(ElderKey key);

    int updateByPrimaryKeySelective(Elder record);

    int updateByPrimaryKey(Elder record);
}