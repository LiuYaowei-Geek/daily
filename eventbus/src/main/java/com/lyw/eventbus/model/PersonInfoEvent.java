package com.lyw.eventbus.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author liuyaowei488
 * @date created in 2019-8-19 14:49
 */
@Data
@Builder
public class PersonInfoEvent {
    private String name;
    private String age;
}
