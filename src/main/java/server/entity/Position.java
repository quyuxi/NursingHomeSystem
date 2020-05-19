package server.entity;

import java.io.Serializable;
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
    private Integer elderId;

    private static final long serialVersionUID = 1L;
}