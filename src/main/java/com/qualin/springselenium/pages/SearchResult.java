package com.qualin.springselenium.pages;


import com.qualin.springselenium.qualinservice.base.page.QualInBasePage;
import com.qualin.springselenium.qualinservice.customanno.QualInPageObjectClass;
import com.qualin.springselenium.qualinservice.customele.UIObject;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@QualInPageObjectClass
public class SearchResult extends QualInBasePage {

    @FindBy(css = "div.rc")
    private List<UIObject> results;

    public int getCount(){
        return results.size();
    }

    public boolean isAt() {
        return wait.until((driver -> !results.isEmpty()));
    }

}
