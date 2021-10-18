package com.jiangtao.lsp.general;

import com.jiangtao.lsp.base.interfaces.Params;

/**
 * @Author: jiangtao
 * @Date: 2021/10/18 12:24
 */
public class InitializeResult implements Params {
    private ServerCapabilities capabilities;
    private ServerInfo serverInfo;

    public InitializeResult(ServerCapabilities capabilities, ServerInfo serverInfo) {
        this.capabilities = capabilities;
        this.serverInfo = serverInfo;
    }

    public InitializeResult(String name, String version){
        this.capabilities = null;
        this.serverInfo = new ServerInfo(name, version);
    }

    public InitializeResult(String name){
        this.capabilities = null;
        this.serverInfo = new ServerInfo(name);
    }

    public ServerCapabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(ServerCapabilities capabilities) {
        this.capabilities = capabilities;
    }

    public ServerInfo getServerInfo() {
        return serverInfo;
    }

    public void setServerInfo(ServerInfo serverInfo) {
        this.serverInfo = serverInfo;
    }

    private class ServerInfo {
        private String name;
        private String version;

        public ServerInfo(String name, String version) {
            this.name = name;
            this.version = version;
        }

        public ServerInfo(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}
