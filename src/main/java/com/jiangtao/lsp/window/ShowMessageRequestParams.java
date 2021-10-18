package com.jiangtao.lsp.window;

import com.jiangtao.lsp.base.interfaces.Params;
import com.jiangtao.lsp.window.enums.MessageType;
import lombok.Data;

/**
 * @Author: jiangtao
 * @Date: 2021/10/14 21:31
 */

public class ShowMessageRequestParams implements Params {
    private MessageType type;
    private String message;
    private MessageActionItem[] actions;

    public ShowMessageRequestParams(MessageType type, String message, MessageActionItem[] actions) {
        this.type = type;
        this.message = message;
        this.actions = actions;
    }

    public ShowMessageRequestParams(MessageType type, String message) {
        this.type = type;
        this.message = message;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageActionItem[] getActions() {
        return actions;
    }

    public void setActions(MessageActionItem[] actions) {
        this.actions = actions;
    }

    private class MessageActionItem {
        private String title;
    }
}
