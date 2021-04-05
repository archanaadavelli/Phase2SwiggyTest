package com.swiggytest.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
	

//@RunWith(Cucumber.class)				
@CucumberOptions(features="/home/archanakitsgmai/eclipse-workspace/Phase2SwiggyTest/features/homepage.feature"
,glue={"com.swiggytest.tests"}
,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
,tags = {"@HomePage"}
,monochrome = true)						
public class HomePageRunner extends AbstractTestNGCucumberTests		
{		
	
}