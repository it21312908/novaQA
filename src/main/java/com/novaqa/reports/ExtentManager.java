package com.novaqa.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("reports/ExtentReport.html");

            spark.config().setDocumentTitle("NovaQA Automation Report");
            spark.config().setReportName("UI Automation Test Execution");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("Framework", "NovaQA");
            extent.setSystemInfo("Automation", "Selenium + TestNG");
            extent.setSystemInfo("Version", "0.3.0");

            extent.attachReporter(spark);
        }

        return extent;
    }

}