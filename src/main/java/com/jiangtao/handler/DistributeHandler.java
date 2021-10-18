package com.jiangtao.handler;

import com.alibaba.fastjson.JSONObject;
import com.jiangtao.distribute.DistributeManager;
import com.jiangtao.lsp.transfer.TransferInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.lang.reflect.Method;

/**
 * @Author: jiangtao
 * @Date: 2021/10/18 20:16
 */
public class DistributeHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);

        TransferInfo info = (TransferInfo) msg;
        if (((JSONObject) info.getContent()).get("method") != null) {
            String requestMethod = (String) ((JSONObject) info.getContent()).get("method");
            Method method = DistributeManager.getProcessor(requestMethod);
            if (method != null) {
                method.invoke(method.getDeclaringClass().getDeclaredConstructor().newInstance(), ctx, msg);
            }
        }
    }
}
