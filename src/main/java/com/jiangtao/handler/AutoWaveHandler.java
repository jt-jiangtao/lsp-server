package com.jiangtao.handler;

import com.alibaba.fastjson.JSONObject;
import com.jiangtao.lsp.base.FirstRequest;
import com.jiangtao.lsp.transfer.TransferInfo;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author: jiangtao
 * @Date: 2021/10/18 15:10
 */
@ChannelHandler.Sharable
public class AutoWaveHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);

        TransferInfo info = (TransferInfo) msg;
        if (((JSONObject) info.getContent()).get("method") != null) {
            if (((JSONObject) info.getContent()).get("method").equals("initialize")) {
                FirstRequest firstRequest = new FirstRequest(0);
                firstRequest.send(getRemoteAddress(ctx));
            }
        }
    }

    private String getRemoteAddress(ChannelHandlerContext ctx) {
        return ctx.channel().remoteAddress().toString();
    }
}
