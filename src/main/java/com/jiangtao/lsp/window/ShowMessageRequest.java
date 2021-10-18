package com.jiangtao.lsp.window;

import com.jiangtao.lsp.base.Request;
import com.jiangtao.lsp.base.RequestContent;
import com.jiangtao.lsp.base.interfaces.Params;

/**
 * @Author: jiangtao
 * @Date: 2021/10/14 21:25
 */
public class ShowMessageRequest extends Request {

    public ShowMessageRequest(RequestContent content) {
        super(content);
    }

    public ShowMessageRequest(Integer id, String method, Params params){
        super(new RequestContent(id, method, params));
    }
}
