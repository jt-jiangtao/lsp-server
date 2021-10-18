package com.jiangtao.lsp.base;

import com.alibaba.fastjson.JSON;
import com.jiangtao.lsp.base.interfaces.Message;
import com.jiangtao.lsp.base.interfaces.Params;
import com.jiangtao.lsp.window.enums.MessageType;

/**
 * @Author: jiangtao
 * @Date: 2021/10/14 20:48
 */
public class Request extends Message {
    private RequestContent content;

    public Request(RequestContent content) {
        this.content = content;
        autoCalculateHeaderLength();
    }

    public Request(Integer id, String method, Params params){
        this.content = new RequestContent(id, method, params);
        autoCalculateHeaderLength();
    }

    public RequestContent getContent() {
        return content;
    }

    public void setContent(RequestContent content) {
        this.content = content;
    }
}
