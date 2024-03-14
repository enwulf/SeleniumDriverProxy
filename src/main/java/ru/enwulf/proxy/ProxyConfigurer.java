package ru.enwulf.proxy;

import org.openqa.selenium.remote.RemoteWebDriver;

public interface ProxyConfigurer {
    void configure(RemoteWebDriver driver);
}