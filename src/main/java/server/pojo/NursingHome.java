package server.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * NursingHome
 *
 * @author
 */
@Data
public class NursingHome implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    /**
     * 养老院名
     */
    private String nursingHomeName;
}