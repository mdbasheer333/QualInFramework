package com.qualin.springselenium.qualinservice.services;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class WindowSwitchService {

    @Autowired
    private ApplicationContext ctx;

    public void switchToWindowByTitle(final String winTitleToSwitch){
        WebDriver driver=this.ctx.getBean(WebDriver.class);
        driver.getWindowHandles().stream()
                .map(windowId->driver.switchTo().window(windowId).getTitle())
                .filter(windowTitle->windowTitle.equals(winTitleToSwitch))
                .findFirst()
                .orElseGet(()->{throw new RuntimeException("No such window " + winTitleToSwitch);});
    }

    public void switchToWindowByTitlePartial(final String winTitleToSwitch){
        WebDriver driver=this.ctx.getBean(WebDriver.class);

        if(driver.getTitle().startsWith(winTitleToSwitch)){
            return;
        }

        driver.getWindowHandles().stream()
                .map(windowId->driver.switchTo().window(windowId).getTitle())
                .filter(windowTitle->windowTitle.startsWith(winTitleToSwitch))
                .findFirst()
                .orElseGet(()->{
                    System.out.println(driver.getTitle());throw new RuntimeException("No such window " + winTitleToSwitch);});
    }

    public void switchToWindowByIndex(final int windowIndex){
        WebDriver driver=this.ctx.getBean(WebDriver.class);
        String windowToSwitch = driver.getWindowHandles().toArray()[windowIndex].toString();
        driver.switchTo().window(windowToSwitch);
    }

    public void switchToMainWindow(){
        WebDriver driver=this.ctx.getBean(WebDriver.class);
        String windowToSwitch = driver.getWindowHandles().toArray()[0].toString();
        driver.switchTo().window(windowToSwitch);
    }

}
