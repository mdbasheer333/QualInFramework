package com.qualin.springselenium.qualinservice.customele;

public interface UIValidator {

    public void assertTextEquals(String expValue);
    public void assertForVisible();
    public void executeScript(String param);

}
