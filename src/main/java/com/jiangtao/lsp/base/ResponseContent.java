package com.jiangtao.lsp.base;

import com.jiangtao.lsp.base.interfaces.Content;
import lombok.Data;

/**
 * @Author: jiangtao
 * @Date: 2021/10/14 20:52
 */
public class ResponseContent extends Content {
    private Integer id;
    private Object result;
    private ResponseError error;  // choice

    static class ResponseError {
        public Integer code;
        public String message;
        public Object data;
    }

    public ResponseContent(Integer id, Object result, ResponseError error) {
        this.id = id;
        this.result = result;
        this.error = error;
    }

    public ResponseContent(Integer id, Object result) {
        this.id = id;
        this.result = result;
    }

    public ResponseContent(Integer id, ResponseError error) {
        this.id = id;
        this.error = error;
    }

    public ResponseContent(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public ResponseError getError() {
        return error;
    }

    public void setError(ResponseError error) {
        this.error = error;
    }
}
