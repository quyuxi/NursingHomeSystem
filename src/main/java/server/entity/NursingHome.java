package server.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * NursingHome
 * @author 
 */
@Data
public class NursingHome implements Serializable {
    private String id;

    /**
     * 养老院名
     */
    private String nursinghomename;

    private static final long serialVersionUID = 1L;
}