package server.entity;

import java.io.Serializable;
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
    private String dateTime;

    private static final long serialVersionUID = 1L;
}