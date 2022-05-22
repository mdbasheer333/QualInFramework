package com.qualin.springselenium.qualinservice.base.config;

import com.qualin.springselenium.qualinservice.customanno.QualInLazyConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.net.URL;

@QualInLazyConfig
@Profile("remote")
public class RemoteWDConfig{

    @Value("${app.url}")
    private URL url;

   /* @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver fireFoxDriver() {
        return new RemoteWebDriver(url, DesiredCapabilities.firefox());
    }

    @Bean
    @ConditionalOnMissingBean
    public WebDriver chromeDriver() {
        return new RemoteWebDriver(url, DesiredCapabilities.chrome());
    }*/

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver fireFoxDriver() {
        WebDriverManager.firefoxdriver().browserVersion("81.0.2").setup();
        System.out.println("i am remote firefox");
        return new FirefoxDriver();
    }

    @Bean
    @ConditionalOnMissingBean
    public WebDriver chromeDriver() {
        WebDriverManager.chromedriver().browserVersion("86.0.4240.22").setup();
        System.out.println("i am remote chrome");
        return new ChromeDriver();
    }

}
