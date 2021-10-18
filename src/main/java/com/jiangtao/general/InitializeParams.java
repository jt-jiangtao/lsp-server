package com.jiangtao.general;

import com.jiangtao.lsp.basic.WorkDoneProgressParams;

/**
 * @Author: jiangtao
 * @Date: 2021/10/14 22:23
 */
public class InitializeParams extends WorkDoneProgressParams {
    protected Integer processId;
    protected ClientInfo clientInfo;
    protected String local;
    protected String rootPath;

    private class ClientInfo {
    }
}
