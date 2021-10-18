package com.jiangtao.lsp.base;

import com.jiangtao.lsp.base.interfaces.Content;
import lombok.Data;

/**
 * @Author: jiangtao
 * @Date: 2021/10/14 20:52
 */
public class ResponseContent implements Content {
    private Integer id;
    private Object result;
    private ResponseError error;

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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getResult() {
        return result;
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
