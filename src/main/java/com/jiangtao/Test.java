package com.jiangtao;

import com.jiangtao.distribute.Handler;
import com.jiangtao.lsp.base.FirstRequest;
import io.netty.channel.ChannelHandlerContext;

/**
 * @Author: jiangtao
 * @Date: 2021/10/18 19:43
 */
public class Test {
    @Handler(request = "initialize")
    public void method1(ChannelHandlerContext ctx, Object msg) {
        FirstRequest firstRequest = new FirstRequest(0);
        firstRequest.send(getRemoteAddress(ctx));
    }

    private String getRemoteAddress(ChannelHandlerContext ctx) {
        return ctx.channel().remoteAddress().toString();
    }

    @Handler(request = "do/m2")
    public void method2(){
        System.out.println("do/m2");
    }
}
