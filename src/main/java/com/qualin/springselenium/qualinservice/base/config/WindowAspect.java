package com.qualin.springselenium.qualinservice.base.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qualin.springselenium.qualinservice.customanno.QualInWindow;
import com.qualin.springselenium.qualinservice.services.WindowSwitchService;

@Aspect
@Component
public class WindowAspect {

    @Autowired
    private WindowSwitchService windowSwitchService;

    @Before("@target(qualInWindow) && within(com.qualin.springselenium..*)")
    public void before(QualInWindow qualInWindow){
        this.windowSwitchService.switchToWindowByTitlePartial(qualInWindow.value());
    }

    @After("@target(qualInWindow) && within(com.qualin.springselenium..*)")
    public void after(QualInWindow qualInWindow){

    }

}
