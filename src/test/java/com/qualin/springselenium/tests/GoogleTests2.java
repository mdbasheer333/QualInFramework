package com.qualin.springselenium.tests;

import com.qualin.springselenium.qualinservice.base.test.QualInBaseTest;
import com.qualin.springselenium.pages.GooglePage;
import com.qualin.springselenium.qualinservice.customanno.QualInPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleTests2 extends QualInBaseTest {

    @QualInPageObject
    private GooglePage googlePage;

    @Test
    public void verifyTheSeleniumSearchResults3() throws IOException {
        System.out.println("test3 started");
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        this.googlePage.getSearchComponent().search("adv spring java");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        this.googlePage.getScreenshotService().takeScreenshot("test3");
        System.out.println("test3 completed");
    }

    @Test
    public void verifyTheJavaSearchResults4() throws IOException {
        System.out.println("test4 started");
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        this.googlePage.getSearchComponent().search("adv core java");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount()<0);
        this.googlePage.getScreenshotService().takeScreenshot("test4");
        System.out.println("test4 completed");
    }

}
