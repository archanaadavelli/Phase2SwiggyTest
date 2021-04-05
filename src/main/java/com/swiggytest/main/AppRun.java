package com.swiggytest.main;

import java.util.List;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class AppRun {

	public static void main(String[] args) {
	    TestNG testng = new TestNG();
	    List<String> suites = Lists.newArrayList();
	    suites.add("/home/archanakitsgmai/eclipse-workspace/Phase2SwiggyTest/testng.xml");//path to xml..
	    testng.setTestSuites(suites);
	    testng.run();
		
	}

}
