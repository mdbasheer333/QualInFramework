package com.qualin.springselenium.qualinservice.services;

import javax.annotation.PostConstruct;

import org.openqa.selenium.TakesScreenshot;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.qualin.springselenium.qualinservice.base.page.QualInBasePage;

@Lazy
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ScreenshotService extends QualInBasePage {

//    @Autowired
//    private ApplicationContext ctx;

    @Value("${screenshot.path}")
    String pathh;

    @PostConstruct
    public void init() throws InterruptedException {

    }

    public void takeScreenshot(String fileName) {
//        File file = this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
//        try {
//            Path path = Paths.get(pathh);
//            FileCopyUtils.copy(file, path.resolve(fileName + ".png").toFile());
//        } catch (IOException e) {
//            System.out.println(e);
//        }
    }

    public void takeScreenshot(String fileName, TakesScreenshot screenshot) {
//        File file = this.ctx.getBean(screenshot.getClass()).getScreenshotAs(OutputType.FILE);
//        try {
//            Path path = Paths.get(pathh);
//            FileCopyUtils.copy(file, path.resolve(fileName + ".png").toFile());
//        } catch (IOException e) {
//            System.out.println(e);
//        }
    }

}
