package com.qualin.springselenium.qualinservice.customele;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.testng.Assert;

import com.qualin.springselenium.qualinservice.listeners.TestListener;

public class UIObjectImpl implements UIObject {

	private final WebElement element;
	private final String eleName;

	public UIObjectImpl(final WebElement element) {
		this.element = element;
		this.eleName = getFormattedName(element.toString());
	}

	@Override
	public void click() {
		this.element.click();
		TestListener.getLocalThreadExtentTest().get().info("clicked on " + eleName);
	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		this.element.sendKeys(keysToSend);
		TestListener.getLocalThreadExtentTest().get()
				.info("entered <b>\"" + getEnteredValue(keysToSend) + "\"</b> on " + eleName);
	}

	private String getEnteredValue(CharSequence[] keysToSend) {
		return Arrays.asList(keysToSend).stream().reduce((a, b) -> a.toString() + b.toString()).get().toString();
	}

	@Override
	public Point getLocation() {
		return this.element.getLocation();
	}

	@Override
	public void submit() {
		this.element.submit();
	}

	@Override
	public String getAttribute(String name) {
		return this.element.getAttribute(name);
	}

	@Override
	public String getCssValue(String propertyName) {
		return this.element.getCssValue(propertyName);
	}

	@Override
	public Dimension getSize() {
		return this.element.getSize();
	}

	@Override
	public Rectangle getRect() {
		throw new UnsupportedOperationException("getRect() not yet implemented");
	}

	@Override
	public List<WebElement> findElements(By by) {
		return this.element.findElements(by);
	}

	@Override
	public String getText() {
		return this.element.getText();
	}

	@Override
	public String getTagName() {
		return this.element.getTagName();
	}

	@Override
	public boolean isSelected() {
		return this.element.isSelected();
	}

	@Override
	public WebElement findElement(By by) {
		return this.element.findElement(by);
	}

	@Override
	public boolean isEnabled() {
		return this.element.isEnabled();
	}

	@Override
	public boolean isDisplayed() {
		return element.isDisplayed();
	}

	@Override
	public void clear() {
		this.element.clear();
	}

	@Override
	public WebElement getWrappedElement() {
		return this.element;
	}

	@Override
	public Coordinates getCoordinates() {
		return ((Locatable) this.element).getCoordinates();
	}

	@Override
	public boolean elementWired() {
		return (this.element != null);
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
		throw new UnsupportedOperationException("getScreenshotAs() not yet implemented");
	}

	@Override
	public void assertTextEquals(String expValue) {
		Assert.assertTrue(this.element.getAttribute("value").equals(expValue),
				this.toString() + " does not have expValue " + expValue);
	}

	@Override
	public void assertForVisible() {
		boolean flag;
		try {
			flag = this.element.isDisplayed();
		} catch (Exception e) {
			flag = false;
		}
		Assert.assertTrue(flag, this.toString() + " Element not displayed");
	}

	@Override
	public void executeScript(String param) {

	}

	private String getFormattedName(String eleName) {
		try {
			if (!eleName.contains("xparth")) {
				eleName = eleName.split("->")[1].split(":")[1].replace("]", "");
			} else {
				eleName = eleName.split("->")[1];
			}
		} catch (Exception e) {

		}
		return eleName;
	}

}
