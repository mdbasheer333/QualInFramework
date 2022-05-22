package com.qualin.springselenium.pages;

import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;

import com.qualin.springselenium.qualinservice.base.page.QualInBasePage;
import com.qualin.springselenium.qualinservice.customanno.QualInPageObjectClass;
import com.qualin.springselenium.qualinservice.customanno.QualInTakeScreenshot;
import com.qualin.springselenium.qualinservice.customele.UIObject;

@QualInPageObjectClass
public class HDFCHomePageObject extends QualInBasePage {

    @Value("${app.url}")
    private String appUrl;

    @FindBy(name = "fldLoginUserId")
    private UIObject txtUserName;

    @FindBy(linkText = "Terms and Conditions")
    private UIObject linkTC;

    public void goTo(){
        getDriver().get("https://netbanking.hdfcbank.com/netbanking/");
    }

    public UIObject getTxtUserName() {
        return txtUserName;
    }

    public UIObject getLinkTC() {
        return linkTC;
    }

    @QualInTakeScreenshot("crateDummyTest")
    public void crateDummyTest() {
        System.out.println("hello taking screenshot");
    }
}
