package server.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Elder
 * @author 
 */
@Data
public class Elder implements Serializable {
    private String id;

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
    private String nId;

    /**
     * 活动范围
     */
    private String area;

    private static final long serialVersionUID = 1L;
}