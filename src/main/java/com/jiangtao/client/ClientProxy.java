package com.jiangtao.client;

import com.alibaba.fastjson.JSON;
import com.jiangtao.lsp.base.Request;
import com.jiangtao.lsp.base.interfaces.Message;
import com.jiangtao.server.LSPServerManager;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @Author: jiangtao
 * @Date: 2021/10/17 19:47
 */
@Slf4j
public class ClientProxy{

    public static Client getInstance(Request request) {
        ClassLoader classLoader = Client.class.getClassLoader();
        Class<?>[] interfaces = new Class[]{Client.class};
        Object o = Proxy.newProxyInstance(classLoader, interfaces, (proxy, method, args) -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Content-Length: ");
            stringBuilder.append(request.getHeader().getContentLength());
            stringBuilder.append("\r\n");
            stringBuilder.append("Content-Type: ");
            stringBuilder.append(request.getHeader().getContentType());
            stringBuilder.append("\r\n");
            stringBuilder.append("\r\n");
            stringBuilder.append(JSON.toJSON(request.getContent()));
            for (Map.Entry<String, Channel> entry : LSPServerManager.getMap().entrySet()) {
                Channel channel = entry.getValue();
                channel.writeAndFlush(stringBuilder.toString());
                log.info("SendMessage: (To: " + entry.getKey() + ") ->->" + stringBuilder.toString());
            }
            return stringBuilder.toString();
        });
        return (Client) o;
    }
}
