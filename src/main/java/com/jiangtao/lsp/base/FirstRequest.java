package com.jiangtao.lsp.base;

import com.alibaba.fastjson.JSON;
import com.jiangtao.lsp.base.interfaces.Content;
import com.jiangtao.lsp.base.interfaces.Message;
import com.jiangtao.lsp.base.interfaces.Params;
import com.jiangtao.lsp.general.InitializeResult;

/**
 * @Author: jiangtao
 * @Date: 2021/10/18 12:35
 */
public class FirstRequest extends Message {
    private FirstResponseContent content;

    public FirstRequest(Integer id){
        this.content = new FirstResponseContent(id);
        autoCalculateHeaderLength();
    }

    public FirstRequest(Header header, FirstResponseContent content) {
        this.setHeader(header);
        this.content = content;
    }

    public FirstRequest(Integer id, String name, String version){
        this.content = new FirstResponseContent(id, name, version);
        autoCalculateHeaderLength();
    }

    public FirstRequest(Integer id, String name){
        this.content = new FirstResponseContent(id, name);
        autoCalculateHeaderLength();
    }

    private class FirstResponseContent extends Content {
        private Integer id;
        private Params result;

        public FirstResponseContent(Integer id, Params result) {
            this.id = id;
            this.result = result;
        }

        public FirstResponseContent(Integer id){
            this.id = id;
            this.result = new InitializeResult();
        }

        public FirstResponseContent(Integer id, String name, String version){
            this.id = id;
            this.result = new InitializeResult(name, version);
        }

        public FirstResponseContent(Integer id, String name){
            this.id = id;
            this.result = new InitializeResult(name);
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Params getResult() {
            return result;
        }

        public void setResult(Params result) {
            this.result = result;
        }
    }

    public FirstResponseContent getContent() {
        return content;
    }

    public void setContent(FirstResponseContent content) {
        this.content = content;
    }
}
