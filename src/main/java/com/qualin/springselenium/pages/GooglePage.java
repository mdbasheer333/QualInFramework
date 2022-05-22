package com.qualin.springselenium.pages;


import com.qualin.springselenium.qualinservice.base.page.QualInBasePage;
import com.qualin.springselenium.qualinservice.customanno.QualInPageObjectClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@QualInPageObjectClass
public class GooglePage extends QualInBasePage {

    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private SearchResult searchResult;

    @Value("${app.url}")
    private String appUrl;

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }


    public SearchResult getSearchResult() {
        return searchResult;
    }

    public void goTo() {
        getDriver().get(appUrl);
        getDriver().manage().window().maximize();
    }


    public boolean isAt() {
        return searchComponent.isAt();
    }

}
