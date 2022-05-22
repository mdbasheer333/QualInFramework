package com.qualin.springselenium.qualinservice.base.page;

import com.qualin.springselenium.qualinservice.customanno.QualInScreenshot;
import com.qualin.springselenium.qualinservice.customele.ElementFactory;
import com.qualin.springselenium.qualinservice.services.ScreenshotService;
import com.qualin.springselenium.qualinservice.services.WindowSwitchService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//public class QualInBasePage {
    public abstract class QualInBasePage {

    public WebDriver getDriver() {
        return driver;
    }

    @Autowired
    private WindowSwitchService windowSwitchService;

    @Autowired
    @Lazy
    private WebDriver driver;

    @Autowired
    @Lazy
    protected WebDriverWait wait;

    @QualInScreenshot
    private ScreenshotService screenshotService;

    @PostConstruct
    private void init(){
        ElementFactory.initElements(this.driver,this);
    }

    @PreDestroy
    public void tearDown(){
        driver.quit();
    }

    //public abstract boolean isAt();

    public ScreenshotService getScreenshotService() {
        return screenshotService;
    }

    public WindowSwitchService getWindowSwitchService() {
        return windowSwitchService;
    }
}
