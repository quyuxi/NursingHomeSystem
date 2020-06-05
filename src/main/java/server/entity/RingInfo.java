package server.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * RingInfo
 * @author 
 */
@Data
public class RingInfo implements Serializable {
    /**
     * 手环id
     */
    private String ringId;

    /**
     * 电池电量
     */
    private Integer battery;

    /**
     * 最后更新时间
     */
    private Date dateTime;

    private static final long serialVersionUID = 1L;

    public RingInfo() {
    }

    public RingInfo(String ringId, Integer battery, Date dateTime) {
        this.ringId = ringId;
        this.battery = battery;
        this.dateTime = dateTime;
    }
}