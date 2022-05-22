package com.qualin.springselenium.qualinservice.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qualin.springselenium.qualinservice.services.ExtentReportingService;


public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentReportingService.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    
//	@Autowired
//	ReportingRepo reporingRepo;
    
    public static synchronized ThreadLocal<ExtentTest> getLocalThreadExtentTest() {
    	return test;
    } 
    
    @Override
    public synchronized void onStart(ITestContext context) {
        System.out.println("Extent Reports Version 3 Test Suite started!");
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        System.out.println(("Extent Reports Version 3  Test Suite is ending!"));
        extent.flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " started!"));
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
        test.set(extentTest);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " passed!"));
        test.get().pass("Test passed");
        //reporingRepo.save(new Reporting(result.getMethod().getMethodName(), "desc of " + result.getMethod().getMethodName(), "pass"));
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " failed!"));
        test.get().fail(result.getThrowable());
        result.getTestContext().setAttribute("extentObject",test);
        //reporingRepo.save(new Reporting(result.getMethod().getMethodName(), "desc of " + result.getMethod().getMethodName(), "failed"));
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " skipped!"));
        test.get().skip(result.getThrowable());
        //reporingRepo.save(new Reporting(result.getMethod().getMethodName(), "desc of " + result.getMethod().getMethodName(), "skipped"));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }
        
}
