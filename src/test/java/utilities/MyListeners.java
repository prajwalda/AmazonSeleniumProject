package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/*
* 2 ways to implement listener class
1) class myListener implements ItestListener{

   }
2) class myListener extends TestListenerAdapter{

   }
* */

public class MyListeners implements ITestListener {

    public void onStart(ITestContext context) {
        System.out.println("Test execution Started");
    }

    public void onTestStart(ITestResult result) {
        System.out.println("Test Started");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped...");

    }

    public void onFinish(ITestContext context) {
        System.out.println("Test execution Completed");

    }
}
