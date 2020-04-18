package com.lyw.annotationInterface;

import java.lang.annotation.*;

/**
 * @author liuyaowei488
 * @date created in 2019-12-13 15:07
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StringNotEmpty {
    String msg();
}
