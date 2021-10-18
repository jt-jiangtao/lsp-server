package com.jiangtao.lsp.base;

import com.jiangtao.lsp.base.interfaces.Content;
import com.jiangtao.lsp.base.interfaces.Params;
import lombok.Data;

/**
 * @Author: jiangtao
 * @Date: 2021/10/14 20:50
 */
public class RequestContent implements Content {
    private Integer id;
    private String method;
    private Params params;

    public RequestContent(Integer id, String method, Params params) {
        this.id = id;
        this.method = method;
        this.params = params;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }
}
