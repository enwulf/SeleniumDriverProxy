package ru.enwulf.proxy;

public enum ProxyProtocol {
    SOCKS4("socks4"),
    SOCKS5("socks"),
    HTTPS("https"),
    HTTP("http");

    private final String name;

    ProxyProtocol(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
