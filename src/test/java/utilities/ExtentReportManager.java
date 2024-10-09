package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;   // UI of the report.
    public ExtentReports reports;               // populate common info on the report.
    public ExtentTest test;                     // creating test case entries in the report and update of the test methods.


    public void onStart(ITestContext context){

        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");

        sparkReporter.config().setDocumentTitle("Automation Testing");
        sparkReporter.config().setReportName("Amazon.in Automation Test");
        sparkReporter.config().setTheme(Theme.DARK);

        reports = new ExtentReports();
        reports.attachReporter(sparkReporter);

        reports.setSystemInfo("Computer name","Prajwal");
        reports.setSystemInfo("Environment","QA");
        reports.setSystemInfo("Tester name","Prajwal");
        reports.setSystemInfo("OS","Ubuntu");
        reports.setSystemInfo("Browser","Chrome");

    }
    public void onTestSuccess(ITestResult result){

        test = reports.createTest(result.getName());
        test.log(Status.PASS,"Test case Passed is : " + result.getName());

    }

    public void onTestFailure(ITestResult result){

        test = reports.createTest(result.getName());
        test.log(Status.FAIL,"Test case Fail is : " + result.getName());
        test.log(Status.FAIL,"Test case Fail reason is : " + result.getThrowable());

    }

    public void onFinish(ITestContext context){
        reports.flush();
    }

}
