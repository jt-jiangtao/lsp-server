package com.jiangtao.lsp.base;

import com.alibaba.fastjson.JSON;
import com.jiangtao.lsp.base.interfaces.Message;
import com.jiangtao.lsp.base.interfaces.Params;
import com.jiangtao.lsp.window.enums.MessageType;

/**
 * @Author: jiangtao
 * @Date: 2021/10/14 20:48
 */
public class Request implements Message{
    private Header header;
    private RequestContent content;

    private void autoCalculateHeaderLength(){
        this.header = new Header(JSON.toJSON(content).toString().length());
    }

    public Request(RequestContent content) {
        this.content = content;
        autoCalculateHeaderLength();
    }

    public Request(Integer id, String method, Params params){
        this.content = new RequestContent(id, method, params);
        autoCalculateHeaderLength();
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public RequestContent getContent() {
        return content;
    }

    public void setContent(RequestContent content) {
        this.content = content;
    }
}
