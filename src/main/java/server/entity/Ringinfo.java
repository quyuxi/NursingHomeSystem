package server.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * RingInfo
 * @author 
 */
@Data
public class Ringinfo implements Serializable {
    /**
     * 手环唯一识别码
     */
    private Integer ringId;

    /**
     * 电池电量
     */
    private Integer power;

    private static final long serialVersionUID = 1L;
}