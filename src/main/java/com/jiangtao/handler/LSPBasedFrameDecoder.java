package com.jiangtao.handler;

import com.jiangtao.lsp.transfer.TransferInfo;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: jiangtao
 * @Date: 2021/10/13 21:36
 */
@Slf4j
public class LSPBasedFrameDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        Object decoded = decode(ctx, in);
        if (decoded != null) {
            out.add(decoded);
        }
    }

    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        String data = in.toString(Charset.defaultCharset());
        TransferInfo info = new TransferInfo();
        if (data.startsWith("Content-Length:")){
            Pattern lengthPattern = Pattern.compile("Content-Length:\s*(\\d+)\r\n");
            Pattern typePattern = Pattern.compile("Content-Type:\s*(\\d+)\r\n");
            Matcher lengthMatch = lengthPattern.matcher(data);
            Matcher typeMatch = typePattern.matcher(data);
            while (lengthMatch.find()){
                info.setContentLength(Integer.parseInt(lengthMatch.group(1)));
            }
            while (typeMatch.find()){
                info.setContentType(typeMatch.group(1));
            }
            String[] splitData =  data.split("\r\n\r\n");
            if (info.getContentLength() > (data.length() - splitData[0].length())) return null;
            else {
                in.readBytes(splitData[0].length() + 4);
                info.setContent(in.readBytes(info.getContentLength()).toString(Charset.defaultCharset()));
            }
        }else {
            return null;
        }
        return info;
    }
}
