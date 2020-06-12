package server.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * SystemUser
 *
 * @authorRingRecord
 */
@Data
public class SystemUser {
    private String id;    //格式"u + nursHomeId + localId" 如 "u 01 0001"
    private String password;
    private String role;
    private int nursHomeId;
    private String realName;
    private String sex;
    private String birthday;    //"2020-06-07"  只显示到日期
    private String phone;
}