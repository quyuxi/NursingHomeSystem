package server.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * SystemUser
 * @author 
 */
@Data
public class SystemUser implements Serializable {
    private Integer id;

    /**
     * 所属养老院
     */
    private String nId;

    /**
     * 角色：包括管理员和普通用户
     */
    private Object role;

    private String userName;

    private String password;

    /**
     * 手机号
     */
    private String phone;

    private static final long serialVersionUID = 1L;
}