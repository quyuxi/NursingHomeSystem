package server.entity;

import java.io.Serializable;
import java.util.Date;
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
    private String elderId;

    /**
     * 最后更新时间
     */
    private Date dateTime;

    private static final long serialVersionUID = 1L;

    public Posture() {
    }

    public Posture(Integer id, String triaxialAcceleration, String triaxialAngularVelocity, String elderId, Date dateTime) {
        this.id = id;
        this.triaxialAcceleration = triaxialAcceleration;
        this.triaxialAngularVelocity = triaxialAngularVelocity;
        this.elderId = elderId;
        this.dateTime = dateTime;
    }
}