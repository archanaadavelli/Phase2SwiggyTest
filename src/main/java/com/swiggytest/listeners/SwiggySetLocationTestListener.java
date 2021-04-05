package com.swiggytest.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.swiggytest.logs.Logger;

public class SwiggySetLocationTestListener implements ITestListener{
	
	Logger logger;
	
	@Override		
    public void onFinish(ITestContext Result) {					
        System.out.println("The name of the suite Finished is :"+Result.getName());				
        logger.writeLog("Finishing Test");
        logger.closeLog();
    }		

    @Override		
    public void onStart(ITestContext Result) {					
        System.out.println("The name of the suite Started is :"+Result.getName());	
        logger = new Logger("swiggyTest");
        logger.writeLog("Starting Test at : ");
        
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {					
        System.out.println("The name of the testcase failed with percentage is :"+Result.getName());				
        		
    }		

    @Override		
    public void onTestFailure(ITestResult Result) {					
        System.out.println("The name of the testcase failed is :"+Result.getName());				
        		
    }		

    @Override		
    public void onTestSkipped(ITestResult Result) {					
        System.out.println("The name of the testcase skipped is :"+Result.getName());				
        		
    }		

    @Override		
    public void onTestStart(ITestResult Result) {					
        System.out.println("The name of the testcase started is :"+Result.getName());				
        		
    }		

    @Override		
    public void onTestSuccess(ITestResult Result) {					
        System.out.println("The name of the testcase succeeded is :"+Result.getName());				
        		
    }	
}
