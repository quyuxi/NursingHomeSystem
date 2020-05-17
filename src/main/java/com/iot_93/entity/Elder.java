package com.iot_93.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Elder
 * @author 
 */
@Data
public class Elder extends ElderKey implements Serializable {
    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 入院时间
     */
    private String startTime;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 子女姓名
     */
    private String childName;

    /**
     * 子女id
     */
    private String childId;

    /**
     * 所属养老院id
     */
    private Integer nId;

    private static final long serialVersionUID = 1L;
}