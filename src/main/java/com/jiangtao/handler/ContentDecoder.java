package com.jiangtao.handler;

import com.alibaba.fastjson.JSON;
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
public class ContentDecoder extends MessageToMessageCodec<TransferInfo, TransferInfo> {

    @Override
    protected void encode(ChannelHandlerContext ctx, TransferInfo msg, List<Object> out) throws Exception {
        msg.setContent(JSON.toJSONString(msg.getContent()));
        out.add(msg);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, TransferInfo msg, List<Object> out) throws Exception {
        Object object = JSON.parseObject((String) msg.getContent());
        msg.setContent(object);
        out.add(msg);
    }
}
