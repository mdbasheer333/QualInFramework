package com.qualin.springselenium.qualinservice.customele;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Locatable;

@ImplementedBy()
public interface UIObject extends WebElement, WrapsElement, Locatable, UIValidator {
    boolean elementWired();
}