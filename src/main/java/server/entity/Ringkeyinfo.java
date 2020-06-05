package server.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * RingKeyInfo
 * @author 
 */
@Data
public class Ringkeyinfo implements Serializable {
    private Integer id;

    /**
     * 手环id
     */
    private String ringId;

    /**
     * 最后更新时间
     */
    private Date dateTime;

    private static final long serialVersionUID = 1L;
}