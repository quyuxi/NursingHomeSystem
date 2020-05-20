package server.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author  quyuxi
 * @since 2020/5/20
 */
@Data
public class SystemUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 所属养老院
     */
    private Integer nId;
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
}