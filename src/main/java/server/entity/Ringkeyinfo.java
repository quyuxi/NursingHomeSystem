package server.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * RingKeyInfo
 * @author 
 */
@Data
public class Ringkeyinfo implements Serializable {
    private Integer id;

    /**
     * 老人
     */
    private Integer elderId;

    private static final long serialVersionUID = 1L;
}