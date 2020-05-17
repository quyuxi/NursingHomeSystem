package com.iot_93.mapper;

import com.iot_93.entity.Ring;
import com.iot_93.entity.RingKey;

public interface RingMapper {
    int deleteByPrimaryKey(RingKey key);

    int insert(Ring record);

    int insertSelective(Ring record);

    Ring selectByPrimaryKey(RingKey key);

    int updateByPrimaryKeySelective(Ring record);

    int updateByPrimaryKey(Ring record);
}