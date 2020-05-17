package com.iot_93.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * Elder
 * @author 
 */
@Data
public class RelativesKey implements Serializable {
    private Integer id;

    /**
     * 手环识别码
     */
    private Integer ringId;

    private static final long serialVersionUID = 1L;
}