package com.novaqa.listeners;

import com.aventstack.extentreports.Status;
import com.novaqa.base.BaseTest;
import com.novaqa.reports.ExtentManager;
import com.novaqa.reports.ExtentTestManager;
import com.novaqa.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentManager.getInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTestManager.setTest(
                ExtentManager.getInstance()
                        .createTest(result.getMethod().getMethodName())
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTestManager.getTest()
                .log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        BaseTest test = (BaseTest) result.getInstance();

        WebDriver driver = test.getDriver();

        String screenshotPath = ScreenshotUtil.capture(
                driver,
                result.getMethod().getMethodName()
        );

        ExtentTestManager.getTest()
                .log(Status.FAIL, result.getThrowable())
                .addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentTestManager.getTest()
                .log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        ExtentManager.getInstance().flush();

        ExtentTestManager.unload();
    }
}