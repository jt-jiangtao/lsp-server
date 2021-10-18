package com.jiangtao;

import com.jiangtao.server.LSPServerManager;

public class Main {
    public static void main(String[] args) {
        new LSPServerManager(8081).start();
    }
}







//package com.jiangtao;
//
//import com.alibaba.fastjson.JSONObject;
//import com.jiangtao.lsp.transfer.TransferInfo;
//import com.jiangtao.handler.ContentDecoder;
//import com.jiangtao.handler.LSPBasedFrameDecoder;
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.*;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import io.netty.handler.codec.bytes.ByteArrayEncoder;
//import io.netty.handler.codec.string.StringEncoder;
//import io.netty.handler.logging.LogLevel;
//import io.netty.handler.logging.LoggingHandler;
//import lombok.extern.slf4j.Slf4j;

/**
 * @Author: jiangtao
 * @Date: 2021/10/13 20:38
 */

//@Slf4j
//public class Main {
//    public static void main(String[] args) {
//        NioEventLoopGroup boss = new NioEventLoopGroup();
//        NioEventLoopGroup worker = new NioEventLoopGroup();
//        LoggingHandler LOGGING_HANDLER = new LoggingHandler(LogLevel.DEBUG);
//        ContentDecoder CONTENT_DECODER = new ContentDecoder();
//        try {
//            ServerBootstrap serverBootstrap = new ServerBootstrap();
//            serverBootstrap.channel(NioServerSocketChannel.class);
//            serverBootstrap.group(boss, worker);
//            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
//                @Override
//                protected void initChannel(SocketChannel ch) throws Exception {
//                    ChannelPipeline pipeline = ch.pipeline();
//                    pipeline.addLast(new LSPBasedFrameDecoder());
//                    pipeline.addLast(CONTENT_DECODER);
//                    ch.pipeline().addLast(LOGGING_HANDLER);
//                    ch.pipeline().addLast(new StringEncoder());
//                    ch.pipeline().addLast(new ByteArrayEncoder());
//                    ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
//                        @Override
//                        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//                            TransferInfo info = (TransferInfo) msg;
//                            String content = "";
//                            String ms = "";
//                            if (((JSONObject) info.getContent()).get("method") != null) {
//                                if (((JSONObject) info.getContent()).get("method").equals("initialize")) {
//                                    content = "{\"jsonrpc\":\"2.0\",\"id\":0,\"result\":{\"capabilities\":{}}}";
//                                    ms = "Content-Length: "+content.length()+"\r\n\r\n"+content;
//                                    ctx.writeAndFlush(ms);
//                                }
//                            }
//
//                            if (((JSONObject) info.getContent()).get("method") != null){
//                                if (((JSONObject) info.getContent()).get("method").equals("workspace/didChangeWatchedFiles")){
////                                    content = "{\"jsonrpc\":\"2.0\",\"id\":0,\"method\":\"window/showMessageRequest\",\"params\":{\"type\":1,\"message\":\"hello\"}}";
//                                    content = "{\"jsonrpc\":\"2.0\",\"id\":0,\"method\":\"window/showMessageRequest\",\"params\":{\"type\":1,\"message\":\"hello\",\"actions\":[\"Retry\",\"No\"]}}";
////                                    content = "{\"jsonrpc\":\"2.0\",\"id\":0,\"method\":\"window/logMessage\",\"params\":{\"type\":1,\"message\":\"hello\"}}";
//                                    ms = "Content-Length: "+content.length()+"\r\n\r\n"+content;
//                                    ctx.writeAndFlush(ms);
//                                }
//                            }
//                            super.channelRead(ctx, msg);
//                        }
//                    });
//                }
//            });
//            Channel channel = serverBootstrap.bind("127.0.0.1",8081).sync().channel();
//            channel.closeFuture().sync();
//        }catch (InterruptedException e){
//            log.error("Server error", e);
//        }finally {
//            boss.shutdownGracefully();
//            worker.shutdownGracefully();
//        }
//    }
//}

