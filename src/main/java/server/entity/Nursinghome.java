package server.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * NursingHome
 *
 * @author
 */
@Data
public class Nursinghome implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 养老院名
     */
    private String nursinghomename;
}