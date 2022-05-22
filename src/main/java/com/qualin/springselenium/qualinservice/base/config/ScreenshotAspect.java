package com.qualin.springselenium.qualinservice.base.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.qualin.springselenium.qualinservice.customanno.QualInScreenshot;
import com.qualin.springselenium.qualinservice.customanno.QualInTakeScreenshot;
import com.qualin.springselenium.qualinservice.services.ScreenshotService;

@Aspect
@Component
public class ScreenshotAspect {

    @QualInScreenshot
    private ScreenshotService screenshotService;

    @After("@annotation(qualInTakeScreenshot)")
    public void after(QualInTakeScreenshot qualInTakeScreenshot){
        screenshotService.takeScreenshot(qualInTakeScreenshot.value());
    }

}
