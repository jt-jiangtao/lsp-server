package com.jiangtao.lsp.transfer;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author: jiangtao
 * @Date: 2021/10/13 21:29
 */
@Data
@Accessors(chain = true)
@ToString
public class TransferInfo {
    private int contentLength;
    private transient String contentType;
    private Object content;
}
