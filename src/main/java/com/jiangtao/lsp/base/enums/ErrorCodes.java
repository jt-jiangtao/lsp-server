package com.jiangtao.lsp.base.enums;

/**
 * @Author: jiangtao
 * @Date: 2021/10/14 20:56
 */
public enum ErrorCodes {
    ParseError(-32700),
    InvalidRequest(-32600),
    MethodNotFound(-32601),
    InvalidParams(-32602),
    InternalError(-32603),
    jsonrpcReservedErrorRangeStart(-32099),
    serverErrorStart(jsonrpcReservedErrorRangeStart),
    ServerNotInitialized(-32002),
    UnknownErrorCode(-32001),
    jsonrpcReservedErrorRangeEnd(-32000),
    serverErrorEnd(jsonrpcReservedErrorRangeEnd),
    lspReservedErrorRangeStart(-32899),
    RequestFailed(-32803),
    ServerCancelled(-32802),
    ContentModified(-32801),
    RequestCancelled(-32800),
    lspReservedErrorRangeEnd(-32800);

    private Integer errorCode;

    ErrorCodes(Integer errorCode) {
        this.errorCode = errorCode;
    }

    ErrorCodes(ErrorCodes errorCodes){
        this.errorCode = errorCodes.errorCode;
    }
}
