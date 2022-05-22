package com.qualin.springselenium.qualinservice.base.config;

import com.qualin.springselenium.qualinservice.customanno.QualInLazyConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

@QualInLazyConfig
@Profile("!remote")
public class WebdriverConfig {

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    @Scope("browserscope")
    public WebDriver fireFoxDriver() {
        WebDriverManager.firefoxdriver().browserVersion("81.0.2").setup();
        System.out.println("i am local firefox");
        return new FirefoxDriver();
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "ie")
    @Scope("browserscope")
    public WebDriver internetExplorerDriver() {

        WebDriverManager.iedriver().arch32().browserVersion("3.9.0").setup();
        System.out.println("i am local ie");

        InternetExplorerOptions options = new InternetExplorerOptions();
        options.setAcceptInsecureCerts(true);
        options.ignoreZoomSettings();
        options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, false);
        options.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
        options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);

        return new InternetExplorerDriver(options);

    }

    @Bean
    @ConditionalOnMissingBean
    @Scope("browserscope")
    public WebDriver chromeDriver() {
        WebDriverManager.chromedriver().browserVersion("86.0.4240.22").setup();
        System.out.println("i am local chrome");
        return new ChromeDriver();
    }

}

