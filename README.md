## Introduction
This library facilitates the utilization of private and public proxies by integrating an extension into Selenium.

## Example



```java

ProxySettings settings = new ProxySettings(ProxyProtocol.HTTP, "127.0.0.1", 8081);
settings.setUsername("alZK1qk");
settings.setPassword("qoKzGGg");

FirefoxDriverProxy proxy = new FirefoxDriverProxy(settings);

FirefoxDriver driver = new FirefoxDriver();
proxy.configure(driver);

driver.get("https://www.ident.me/");
```
