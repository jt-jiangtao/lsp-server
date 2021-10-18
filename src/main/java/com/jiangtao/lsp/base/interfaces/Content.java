package com.jiangtao.lsp.base.interfaces;

/**
 * @Author: jiangtao
 * @Date: 2021/10/14 21:39
 */
public abstract class Content {
    public String jsonrpc = "2.0";

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }
}
