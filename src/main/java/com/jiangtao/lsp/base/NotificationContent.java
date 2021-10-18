package com.jiangtao.lsp.base;

import com.jiangtao.lsp.base.interfaces.Content;
import com.jiangtao.lsp.base.interfaces.Params;
import lombok.Data;

/**
 * @Author: jiangtao
 * @Date: 2021/10/14 21:03
 */
public class NotificationContent extends Content {
    private String method;
    private Params params;

    public NotificationContent(String method, Params params) {
        this.method = method;
        this.params = params;
    }

    public String getMethod() {
        return method;
    }

    public Params getParams() {
        return params;
    }
}
