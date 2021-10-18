package com.jiangtao.lsp.window.enums;

/**
 * @Author: jiangtao
 * @Date: 2021/10/14 21:12
 */
public enum MessageType {
    Error(1),
    Warning(2),
    Info(2),
    Log(2);

    private int index;
    MessageType(int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
