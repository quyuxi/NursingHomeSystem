package server.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Physiological
 *
 * @author
 */
@Data
public class Physiological implements Serializable {
    private static final long serialVersionUID = 1L;
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
    private Integer elderId;
}