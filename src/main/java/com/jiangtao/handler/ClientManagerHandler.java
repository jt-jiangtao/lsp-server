package com.jiangtao.handler;

import com.jiangtao.client.Client;
import com.jiangtao.client.ClientProxy;
import com.jiangtao.lsp.base.FirstRequest;
import com.jiangtao.server.LSPServerManager;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: jiangtao
 * @Date: 2021/10/17 20:22
 */
@Slf4j
public class ClientManagerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);

        LSPServerManager.getMap().put(getRemoteAddress(ctx), ctx.channel());
        log.info("Client: " + getRemoteAddress(ctx) + " connected.");

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);

        LSPServerManager.getMap().remove(getRemoteAddress(ctx));
        ctx.close();
    }

    private String getRemoteAddress(ChannelHandlerContext ctx) {
        return ctx.channel().remoteAddress().toString();
    }
}
