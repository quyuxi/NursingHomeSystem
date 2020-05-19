package server.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * Posture
 * @author 
 */
@Data
public class Posture implements Serializable {
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

    private static final long serialVersionUID = 1L;
}