package server.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Physiological
 * @author 
 */
@Data
public class Physiological implements Serializable {
    private Integer id;

    /**
     * 心率
     */
    private String heartRate;

    /**
     * 血压
     */
    private Integer bloodPressure;

    /**
     * 体温
     */
    private Double temperature;

    /**
     * 老人
     */
    private String elderId;

    /**
     * 最后更新时间
     */
    private Long dateTime;

    private static final long serialVersionUID = 1L;
}