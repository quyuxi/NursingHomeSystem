package server.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author  quyuxi
 * @since 2020/5/20
 */
@Data
public class Ringkeyinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 老人
     */
    private Integer elderId;
}