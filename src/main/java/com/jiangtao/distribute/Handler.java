package com.jiangtao.distribute;

import java.lang.annotation.*;

/**
 * @Author: jiangtao
 * @Date: 2021/10/18 18:40
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Handler {
    String request();
}
