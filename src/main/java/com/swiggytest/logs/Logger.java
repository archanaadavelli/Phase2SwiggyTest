package com.swiggytest.logs;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

	FileWriter myLog;
	
	public Logger(String fileName) {
		try {
			myLog = new FileWriter("/home/archanakitsgmai/eclipse-workspace/Phase2SwiggyTest/logs/"+fileName+".log");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void writeLog(String logText) {
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
		
		try {
			System.out.println(timeStamp);
			myLog.write(timeStamp+" : "+logText);
		//	myLog.write(String.format("%n"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeLog() {
		try {
			myLog.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
