package com.qualin.springselenium.tests;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualin.springselenium.pages.GooglePage;
import com.qualin.springselenium.qualinservice.base.test.QualInBaseTest;
import com.qualin.springselenium.qualinservice.customanno.QualInPageObject;


public class GoogleTests1 extends QualInBaseTest {

    @QualInPageObject
    private GooglePage googlePage;

    @Test(description = "this is verifyTheSeleniumSearchResults1")
    public void verifyTheSeleniumSearchResults1() throws IOException {
        System.out.println("test1 started");
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        this.googlePage.getSearchComponent().search("spring java");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        this.googlePage.getScreenshotService().takeScreenshot("test1");
        System.out.println("test1 completed");
    }

    @Test
    public void verifyTheJavaSearchResults2() throws IOException {
        System.out.println("test2 started");
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        this.googlePage.getSearchComponent().search("core java");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 0);
        this.googlePage.getScreenshotService().takeScreenshot("test2");
        System.out.println("test2 completed");
    }

}
