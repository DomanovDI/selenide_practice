package ru.kinopoisk.config;
import org.aeonbits.owner.Config;

public interface WebDriverConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://www.kinopoisk.ru/")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();
}
