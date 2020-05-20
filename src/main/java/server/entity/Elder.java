package server.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author  quyuxi
 * @since 2020/5/20
 */
@Data
public class Elder extends ElderKey implements Serializable {
    private static final long serialVersionUID = 1L;
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
     * 所属养老院id
     */
    private Integer nId;
}