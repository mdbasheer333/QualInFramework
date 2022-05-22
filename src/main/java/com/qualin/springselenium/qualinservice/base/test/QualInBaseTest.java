package com.qualin.springselenium.qualinservice.base.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;
import com.qualin.springselenium.qualinservice.customanno.QualInScreenshot;
import com.qualin.springselenium.qualinservice.dao.ReportingRepo;
import com.qualin.springselenium.qualinservice.entities.Reporting;

import com.qualin.springselenium.qualinservice.services.ScreenshotService;
import com.qualin.springselenium.qualinservice.services.SequenceGeneratorService;

public class QualInBaseTest extends SpringBaseTestNGTests {

	@QualInScreenshot
	private ScreenshotService screenshotService;

	@Autowired
	ReportingRepo reportingRepo;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	@Autowired
	private ApplicationContext ctx;

	@Value("${screenshot.path}")
	String pathh;

	@BeforeSuite
	public void beforeSuit() {
		System.out.println("----------------beforeSuit-----------------");

	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("----------------beforeTest-----------------");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("----------------beforeClass-----------------");
	}

	@BeforeMethod
	public void init() {
		System.out.println("----------------init-----------------");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		System.out.println("----------------tearDown-----------------");
		try {
			if (result.getStatus() == ITestResult.FAILURE) {
				this.takeScreenshotOnFailure(result);
				this.saveTestResultsIntoDB(result, "fail");
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				this.saveTestResultsIntoDB(result, "pass");
			} else if (result.getStatus() == ITestResult.SKIP) {
				this.saveTestResultsIntoDB(result, "skip");
			} else {
				this.saveTestResultsIntoDB(result, "unknown");
			}
		} catch (Exception e) {

		} finally {
			ctx.getBean(WebDriver.class).quit();
		}
	}

	private void takeScreenshotOnFailure(ITestResult result) throws IOException {
		screenshotService.takeScreenshot(result.getMethod().getMethodName() + "_failed");
		@SuppressWarnings("unchecked")
		ThreadLocal<ExtentTest> obj = (ThreadLocal<ExtentTest>) result.getTestContext().getAttribute("extentObject");
		obj.get().addScreenCaptureFromPath(pathh + result.getMethod().getMethodName() + "_failed.png");
	}

	private void saveTestResultsIntoDB(ITestResult result, String tcStatus) {
		Reporting reporting = new Reporting();
		long longid=sequenceGeneratorService.getNextSequence(Reporting.SEQUENCE_NAME);
		System.out.println("=======================" + longid);
		reporting.setId(longid);
		reporting.setTcName(result.getMethod().getMethodName());
		String desc=result.getMethod().getDescription()==null?"No Description":result.getMethod().getDescription();
		reporting.setTcDescription(desc);
		reporting.setTcStatus(tcStatus);
		reportingRepo.save(reporting);
	}

	@AfterClass
	public void afterClass() {
		System.out.println("----------------afterClass-----------------");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("----------------afterTest-----------------");
	}

	@AfterSuite
	public void afterSuit() {
		System.out.println("----------------afterSuit-----------------");
	}

}
