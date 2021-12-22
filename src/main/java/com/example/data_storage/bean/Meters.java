package com.example.data_storage.bean;

import lombok.Data;

/**
 * @author lujifa@jxtech
 * @version 1.0.0
 * @Description 量测实体类
 * @createTime 2021年12月21日 14:17:00
 */
@Data
public class Meters {
    private Long ts;

    private Long current;

    private Integer voltage;

    private Long phase;

    private String groupid;

    private String location;
}
