package com.jiangtao.lsp.base;

import lombok.Data;

/**
 * @Author: jiangtao
 * @Date: 2021/10/14 20:43
 */
public class Header {
    private Integer contentLength;
    private String contentType = "utf-8";

    public Header() {
    }

    public Header(Integer contentLength) {
        this.contentLength = contentLength;
    }

    public Header(Integer contentLength, String contentType) {
        this.contentLength = contentLength;
        this.contentType = contentType;
    }

    public void setContentType(String contentType){
        this.contentType = contentType;
    }

    public void setContentLength(Integer contentLength) {
        this.contentLength = contentLength;
    }

    public Integer getContentLength() {
        return contentLength;
    }

    public String getContentType() {
        return contentType;
    }
}
