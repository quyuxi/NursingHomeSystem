package server.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Position
 * @author 
 */
@Data
public class Position implements Serializable {
    private Integer id;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 老人
     */
    private String elderId;

    /**
     * 最后更新时间
     */
    private Date dateTime;

    private static final long serialVersionUID = 1L;

    public Position() {
    }

    public Position(Integer id, String latitude, String longitude, String elderId, Date dateTime) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.elderId = elderId;
        this.dateTime = dateTime;
    }
}