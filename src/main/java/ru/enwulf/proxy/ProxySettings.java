package ru.enwulf.proxy;

public class ProxySettings {
    private ProxyProtocol protocol;
    private String host;
    private int port;
    private String username;
    private String password;

    public ProxySettings() {}

    public ProxySettings(ProxyProtocol protocol, String host, int port) {
        this.protocol = protocol;
        this.host = host;
        this.port = port;
    }

    public ProxyProtocol getProtocol() {
        return protocol;
    }

    public void setProtocol(ProxyProtocol protocol) {
        this.protocol = protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}