package com.qualin.springselenium.tests;

import com.qualin.springselenium.pages.GooglePage;
import com.qualin.springselenium.qualinservice.base.test.QualInBaseTest;
import com.qualin.springselenium.qualinservice.customanno.QualInPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class GoogleTests4 extends QualInBaseTest {

    @QualInPageObject
    private GooglePage googlePage;

    @Test
    public void verifyTheSeleniumSearchResults6() throws IOException {
        System.out.println("test6 started");
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        this.googlePage.getSearchComponent().search("j2ee adv spring java");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        this.googlePage.getScreenshotService().takeScreenshot("test6");
        System.out.println("test6 completed");
    }

    @Test
    public void verifyTheJavaSearchResults7() throws IOException {
        System.out.println("test7 started");
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        this.googlePage.getSearchComponent().search("j2ee adv core java");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount()>0);
        this.googlePage.getScreenshotService().takeScreenshot("test7");
        System.out.println("test7 completed");
    }

}
