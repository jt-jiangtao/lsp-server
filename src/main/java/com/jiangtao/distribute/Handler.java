package com.jiangtao.distribute;

import java.lang.annotation.*;

/**
 * @Author: jiangtao
 * @Date: 2021/10/18 18:40
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface Handler {
    String request();
}
