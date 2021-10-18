package com.jiangtao.lsp.window;

import com.jiangtao.lsp.base.Request;
import com.jiangtao.lsp.base.RequestContent;
import com.jiangtao.lsp.window.enums.MessageType;

/**
 * @Author: jiangtao
 * @Date: 2021/10/14 21:34
 */
public class ShowMessageRequestParamsRequest extends Request {
    public ShowMessageRequestParamsRequest( int id, ShowMessageRequestParams params){
        super(new RequestContent(id, "window/showMessageRequest", params));
    }

    public ShowMessageRequestParamsRequest(int id, MessageType type, String message) {
        this(id, new ShowMessageRequestParams(type, message));
    }
}
