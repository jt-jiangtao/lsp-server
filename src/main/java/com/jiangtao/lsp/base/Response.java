package com.jiangtao.lsp.base;

import com.alibaba.fastjson.JSON;
import com.jiangtao.lsp.base.interfaces.Message;

/**
 * @Author: jiangtao
 * @Date: 2021/10/14 21:04
 */
public class Response extends Message {
    private ResponseContent content;


    public Response(ResponseContent content) {
        this.content = content;
        autoCalculateHeaderLength();
    }

    public Response(Integer id){
        this.content = new ResponseContent(id);
        autoCalculateHeaderLength();
    }

    public Response(Integer id, ResponseContent.ResponseError error){
        this.content = new ResponseContent(id, error);
        autoCalculateHeaderLength();
    }

    public Response(Integer id, Object result, ResponseContent.ResponseError error){
        this.content = new ResponseContent(id, result, error);
        autoCalculateHeaderLength();
    }

    public ResponseContent getContent() {
        return content;
    }

    public void setContent(ResponseContent content) {
        this.content = content;
    }
}
