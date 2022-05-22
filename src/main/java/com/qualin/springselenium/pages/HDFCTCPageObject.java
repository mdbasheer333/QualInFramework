package com.qualin.springselenium.pages;

import org.openqa.selenium.support.FindBy;

import com.qualin.springselenium.qualinservice.base.page.QualInBasePage;
import com.qualin.springselenium.qualinservice.customanno.QualInPageObjectClass;
import com.qualin.springselenium.qualinservice.customanno.QualInWindow;
import com.qualin.springselenium.qualinservice.customele.UIObject;

@QualInWindow("HDFC Bank")
@QualInPageObjectClass
public class HDFCTCPageObject extends QualInBasePage {

	@FindBy(xpath = "//a[contains(text(),'Corporate Commitment')]")
    private UIObject linkCorporateCommitment;

    public UIObject getLinkCorporateCommitment() {
        return linkCorporateCommitment;
    }

}
