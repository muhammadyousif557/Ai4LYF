package co.Ai4Lyf.ExtentReportListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportListener implements IReporter {
    private ExtentReports extent;

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        // Create the HTML reporter and configure the report location
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/Ai4Lyf_" + timestamp + ".html");
        // Initialize the ExtentReports instance
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);  // Attach the reporter to ExtentReports

        // Loop through each suite and collect test results
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> results = suite.getResults();

            for (ISuiteResult suiteResult : results.values()) {
                ITestContext context = suiteResult.getTestContext();

                // Process passed, failed, and skipped tests
                buildTestNodes(context.getPassedTests(), Status.PASS);
                buildTestNodes(context.getFailedTests(), Status.FAIL);
                buildTestNodes(context.getSkippedTests(), Status.SKIP);
            }
        }

        // Flush the results and close the report
        extent.flush();
    }

    // Method to process each group of test results (pass, fail, skip)
    private void buildTestNodes(IResultMap tests, Status status) {
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                // Create a new test node for each test result
                ExtentTest test = extent.createTest(result.getMethod().getMethodName());

                // Log the start and end time of the test manually (since ExtentTest doesn't have setStartTime/setEndTime)
                test.info("Start Time: " + getTime(result.getStartMillis()));
                test.info("End Time: " + getTime(result.getEndMillis()));

                // Assign test groups to the test node
                for (String group : result.getMethod().getGroups()) {
                    test.assignCategory(group);
                }

                // Log the test status and details
                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());
                } else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }
            }
        }
    }

    // Method to convert milliseconds to a Date object (for start and end time)
    private String getTime(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return sdf.format(calendar.getTime());
    }
}
