package server.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * RingInfo
 *
 * @author
 */
@Data
public class Ringinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 手环唯一识别码
     */
    private Integer ringId;
    /**
     * 电池电量
     */
    private Integer power;
}