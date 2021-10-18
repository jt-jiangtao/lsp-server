package com.jiangtao.lsp.window;

import com.jiangtao.lsp.base.interfaces.Params;
import com.jiangtao.lsp.window.enums.MessageType;
import lombok.Data;

/**
 * @Author: jiangtao
 * @Date: 2021/10/14 21:10
 */
@Data
public class ShowMessageParams implements Params{
    private MessageType type;
    private String message;
}
