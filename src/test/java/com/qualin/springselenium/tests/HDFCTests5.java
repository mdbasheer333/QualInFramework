package com.qualin.springselenium.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.qualin.springselenium.pages.HDFCHomePageObject;
import com.qualin.springselenium.pages.HDFCTCPageObject;
import com.qualin.springselenium.qualinservice.base.test.QualInBaseTest;
import com.qualin.springselenium.qualinservice.customanno.QualInPageObject;


public class HDFCTests5 extends QualInBaseTest {

    @QualInPageObject
    private HDFCHomePageObject hdfcHomePageObject;

    @QualInPageObject
    private HDFCTCPageObject hdfctcPageObject;


    @BeforeClass
    public void bc(){
        hdfcHomePageObject.goTo();
    }

    @Test(description = "hdfc mutli window test")
    public void verifyTheSeleniumSearchResults8() throws IOException {

        System.out.println("hdfc test started");

        hdfcHomePageObject.getDriver().switchTo().frame(0);
        hdfcHomePageObject.getTxtUserName().sendKeys("123456");
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        hdfcHomePageObject.getScreenshotService().takeScreenshot("hdfc1");
        hdfcHomePageObject.getLinkTC().click();

    }

}
