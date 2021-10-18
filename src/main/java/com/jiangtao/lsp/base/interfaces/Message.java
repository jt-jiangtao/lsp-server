package com.jiangtao.lsp.base.interfaces;

import com.alibaba.fastjson.JSON;
import com.jiangtao.lsp.base.Header;
import com.jiangtao.lsp.base.RequestContent;
import com.jiangtao.server.LSPServerManager;
import io.netty.channel.Channel;

import java.util.Map;

/**
 * @Author: jiangtao
 * @Date: 2021/10/14 20:50
 */
public abstract class Message {
    private Header header;

    public Message() {
        this.header = new Header();
    }

    public Message(Header header) {
        this.header = header;
    }

    public Message(Integer contentLength){
        this.header = new Header(contentLength);
    }

    public boolean send(String address){
        if (LSPServerManager.getMap().size() == 0) return false;
        if (address != null) {
            Channel channel = LSPServerManager.getMap().get(address);
            if (channel == null) return false;
            channel.writeAndFlush(this);
        }
        for (Map.Entry<String, Channel> entry : LSPServerManager.getMap().entrySet()) {
            Channel channel = entry.getValue();
            channel.writeAndFlush(this);
        }
        return true;
    }

    protected void autoCalculateHeaderLength() {
        this.header.setContentLength(JSON.toJSON(getContent()).toString().length());
    }


    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public abstract Content getContent();
}
