package com.swiggytest.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
	

//@RunWith(Cucumber.class)				
@CucumberOptions(features="/home/archanakitsgmai/eclipse-workspace/Phase2SwiggyTest/features/location.feature"
,glue={"com.swiggytest.tests"}
,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
,tags = {"@SwiggyLocation"}
,monochrome = true)						
public class SwiggySetLocaitonRunner extends AbstractTestNGCucumberTests		
{		
	
}
