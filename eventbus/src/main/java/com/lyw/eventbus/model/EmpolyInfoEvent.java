package com.lyw.eventbus.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author liuyaowei488
 * @date created in 2019-8-20 10:36
 */
@Data
@Builder
public class EmpolyInfoEvent {
    private String sex;
    private String position;
}
