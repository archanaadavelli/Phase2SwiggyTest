package com.swiggytest.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

	

//@RunWith(Cucumber.class)				
@CucumberOptions(features="/home/archanakitsgmai/eclipse-workspace/Phase2SwiggyTest/features/login.feature"
,glue={"com.swiggytest.tests"}
,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
,tags = {"@SwiggyLogin"}
,monochrome = true)						
public class VerifyLoginRunner extends AbstractTestNGCucumberTests		
{		

}
