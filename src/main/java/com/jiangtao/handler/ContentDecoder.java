package com.jiangtao.handler;

import com.alibaba.fastjson.JSON;
import com.jiangtao.lsp.base.Request;
import com.jiangtao.lsp.base.interfaces.Message;
import com.jiangtao.lsp.transfer.TransferInfo;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.List;

/**
 * @Author: jiangtao
 * @Date: 2021/10/14 14:30
 */
@ChannelHandler.Sharable
public class ContentDecoder extends MessageToMessageCodec<TransferInfo, Message> {


    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, List<Object> out) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Content-Length: ");
        stringBuilder.append(msg.getHeader().getContentLength());
        stringBuilder.append("\r\n");
        stringBuilder.append("Content-Type: ");
        stringBuilder.append(msg.getHeader().getContentType());
        stringBuilder.append("\r\n");
        stringBuilder.append("\r\n");
        stringBuilder.append(JSON.toJSON(msg.getContent()));
        out.add(stringBuilder.toString());
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, TransferInfo msg, List<Object> out) throws Exception {
        Object object = JSON.parseObject((String) msg.getContent());
        msg.setContent(object);
        out.add(msg);
    }
}
