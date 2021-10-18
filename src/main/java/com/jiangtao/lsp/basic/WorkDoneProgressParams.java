package com.jiangtao.lsp.basic;

import com.jiangtao.lsp.base.interfaces.Params;

/**
 * @Author: jiangtao
 * @Date: 2021/10/14 22:21
 */
public class WorkDoneProgressParams implements Params {
    protected ProgressToken workDoneToken;

    private class ProgressToken {
        private String progressToken;
    }
}
