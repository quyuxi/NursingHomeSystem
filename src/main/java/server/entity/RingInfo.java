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
     * id
     *
     *
     */

    private Integer id;
    /**
     * 手环唯一识别码
     */
    private String ringId;

    /**
     * 电池电量
     */
    private Integer power;

    /**
     * 老人
     */
    private String elderId;

    /**
     * 最后更新时间
     */
    private Date dateTime;

    private static final long serialVersionUID = 1L;

    public RingInfo(Integer id, String ringId, Integer power, String elderId, Date dateTime) {
        this.id = id;
        this.ringId = ringId;
        this.power = power;
        this.elderId = elderId;
        this.dateTime = dateTime;
    }

    public RingInfo() {
    }
}