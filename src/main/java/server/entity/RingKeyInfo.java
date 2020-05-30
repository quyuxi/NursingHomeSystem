package server.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * RingKeyInfo
 * @author 
 */
@Data
public class RingKeyInfo implements Serializable {
    private Integer id;

    /**
     * 老人
     */
    private String elderId;

    /**
     * 最后更新时间
     */
    private Date dateTime;

    private static final long serialVersionUID = 1L;
}