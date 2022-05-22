package com.qualin.springselenium.tests;

import com.qualin.springselenium.pages.GooglePage;
import com.qualin.springselenium.qualinservice.customanno.QualInPageObject;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class GoogleTests3  {

    @QualInPageObject
    private GooglePage googlePage;

    @Test
    public void verifyTheSeleniumSearchResults5() throws IOException {
        System.out.println("test5 started");
        System.out.println("test5 ended");
        Assert.assertEquals(1, 1);
    }

}
