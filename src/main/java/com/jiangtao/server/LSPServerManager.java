package com.jiangtao.server;

import com.alibaba.fastjson.JSONObject;
import com.jiangtao.client.Client;
import com.jiangtao.client.ClientProxy;
import com.jiangtao.handler.AutoWaveHandler;
import com.jiangtao.handler.ClientManagerHandler;
import com.jiangtao.handler.ContentDecoder;
import com.jiangtao.handler.LSPBasedFrameDecoder;
import com.jiangtao.lsp.base.FirstRequest;
import com.jiangtao.lsp.transfer.TransferInfo;
import com.jiangtao.lsp.window.ShowMessageRequestParamsRequest;
import com.jiangtao.lsp.window.enums.MessageType;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: jiangtao
 * @Date: 2021/10/17 20:07
 */
@Slf4j
public class LSPServerManager {
    private int port;
    private static Map<String, Channel> map = new ConcurrentHashMap<String, Channel>();

    public LSPServerManager(int port) {
        this.port = port;
    }

    public LSPServerManager(){
        this.port = 8088;
    }

    public void start() {
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        LoggingHandler LOGGING_HANDLER = new LoggingHandler(LogLevel.DEBUG);
        ContentDecoder CONTENT_DECODER = new ContentDecoder();
        ClientManagerHandler CLIENT_MANAGER_HANDLER = new ClientManagerHandler();
        AutoWaveHandler AUTO_WAVE_HANDLER = new AutoWaveHandler();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.group(boss, worker);
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast(LOGGING_HANDLER);
                    pipeline.addLast(new StringEncoder());
                    pipeline.addLast(new ByteArrayEncoder());

                    // 连接管理handler
                    pipeline.addLast(CLIENT_MANAGER_HANDLER);
                    // LSP解码为Object
                    pipeline.addLast(new LSPBasedFrameDecoder());
                    // 自动第一次招手
                    pipeline.addLast(AUTO_WAVE_HANDLER);
                    // 序列化与反序列化
                    pipeline.addLast(CONTENT_DECODER);

                    // TODO: 调度handler
                    pipeline.addLast(new ChannelInboundHandlerAdapter(){
                        @Override
                        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                            TransferInfo info = (TransferInfo) msg;

                            if (((JSONObject) info.getContent()).get("method") != null){
                                if (((JSONObject) info.getContent()).get("method").equals("workspace/didChangeWatchedFiles")){
                                    ShowMessageRequestParamsRequest showMessageRequestParamsRequest = new ShowMessageRequestParamsRequest(1, MessageType.Error, "hello");
                                    showMessageRequestParamsRequest.send(null);
                                }
                            }
                            super.channelRead(ctx, msg);
                        }
                    });
                }
            });
            Channel channel = serverBootstrap.bind("127.0.0.1", port).sync().channel();
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            log.error("Server error", e);
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

    public static Map<String, Channel> getMap() {
        return map;
    }

    public int getPort() {
        return port;
    }
}
