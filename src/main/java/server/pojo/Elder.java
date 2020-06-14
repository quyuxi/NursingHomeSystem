package server.pojo;

import lombok.Data;

/**
 * Elder
 *
 * @author
 */
@Data
public class Elder {

    private int id;
    private String name;
    private String sex;
    private String idCard;
    private String birthday;
    private String phone;
    private String area;
    private String joinTime;
    private Relative[] relatives;

}