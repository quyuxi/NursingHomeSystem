package server.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Posture
 *
 * @author
 */
@Data
public class Posture implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 三轴加速度
     */
    private String triaxialAcceleration;
    /**
     * 三轴角速度
     */
    private String triaxialAngularVelocity;
    /**
     * 老人
     */
    private Integer elderId;
}