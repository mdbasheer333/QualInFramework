package com.qualin.springselenium.pages;


import com.qualin.springselenium.qualinservice.base.page.QualInBasePage;
import com.qualin.springselenium.qualinservice.customanno.QualInPageObjectClass;
import com.qualin.springselenium.qualinservice.customele.UIObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@QualInPageObjectClass
public class SearchComponent extends QualInBasePage {

    @FindBy(name = "q")
    private UIObject searchBox;

    @FindBy(name = "btnK")
    private List<UIObject> searchBtn;

    public void search(final String keyword) {
        searchBox.sendKeys(keyword);
        searchBox.sendKeys(Keys.TAB);
        searchBtn.stream()
                .filter(e -> e.isDisplayed() && e.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }


    public boolean isAt() {
        return this.wait.until((driver) -> this.searchBox.isDisplayed());
    }

}
