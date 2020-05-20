package server.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Position
 *
 * @author
 */
@Data
public class Position implements Serializable {
    private static final long serialVersionUID = 1L;
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
    private Integer elderId;
}