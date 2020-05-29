package server.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Relatives
 * @author 
 */
@Data
public class Relatives implements Serializable {
    private Integer id;

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
     * 家庭住址
     */
    private String address;

    /**
     * 老人
     */
    private String elderId;

    private static final long serialVersionUID = 1L;
}