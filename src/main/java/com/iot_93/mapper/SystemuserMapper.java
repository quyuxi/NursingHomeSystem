package com.iot_93.mapper;

import com.iot_93.entity.Systemuser;
import com.iot_93.entity.SystemuserKey;

public interface SystemuserMapper {
    int deleteByPrimaryKey(SystemuserKey key);

    int insert(Systemuser record);

    int insertSelective(Systemuser record);

    Systemuser selectByPrimaryKey(SystemuserKey key);

    int updateByPrimaryKeySelective(Systemuser record);

    int updateByPrimaryKey(Systemuser record);
}