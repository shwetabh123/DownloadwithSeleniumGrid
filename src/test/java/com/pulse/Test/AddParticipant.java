package com.pulse.Test;


	import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pulse.Page.Author;
import com.pulse.Page.CompanyDirectory;
import com.pulse.Page.HomePage;
import com.pulse.Page.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

import generic.BasePage;
import generic.BaseTest;

import generic.Excel;
//import mx4j.log.Log;



//@Listeners(generic.RealGuru99TimeReport.class)


	public class AddParticipant extends BaseTest{

	
	static int teststepcount=000000;
	
	
	public static Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
	
	static   Excel eLib = new Excel();
		
	  public static String url = eLib.getCellValue(pathexcel,"PreCon", 1, 0);
	
	  public static String logfiletimestamp;

		public static Properties CONFIG;
	  
	
	  
	//public static	ITestResult result = null;
		
		@Test
		public void addparticipant(Method method) throws Exception
		
		{
			
			driver.get(url);
			
			//driver.get("http://stg-surveys.cebglobal.com/Pulse");
			
			
			Thread.sleep(15000);
			
	   childTest.get().log(Status.INFO, "Running "+method.getName());
			   
				
			   
			   childTest.get().log(Status.INFO, "Logged into "+url);
			   
			   
			   childTest.get().assignCategory("Regression Testing");
			    
	//		 Randomaplphanumber R=new Randomaplphanumber();
			  
	//		String r=  R.Random();
			
				String un=Excel.getCellValue(XLPATH,"ValidLogin",3,0);
				String pw=Excel.getCellValue(XLPATH,"ValidLogin",3,1);
				String accnt=Excel.getCellValue(XLPATH,"ValidLogin",3,2);
	
				String cb=Excel.getCellValue(XLPATH,"Author",3,3);
			       
				//Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
			     
				Logger APP_LOGS = Logger.getLogger(AddParticipant.class);
				
	    		    
				//String HPT=Excel.getCellValue(XLPATH,"ValidLogin",1,2);
				CompanyDirectory cd=new CompanyDirectory(driver);
				
				LoginPage l=new LoginPage(driver);
				
				
		          l.loginbuttondisplayed();
		
		          childTest.get().log(Status.INFO, " verify loginbuttondisplayed ");
				
				l.setUserName(un);
				Thread.sleep(15000);
				
				APP_LOGS.info("type username");
				
				   childTest.get().log(Status.INFO, "type username ");
				
				l.setPassword(pw);
				
				Thread.sleep(15000);
				APP_LOGS.info("type password");
				
				   childTest.get().log(Status.INFO, "type password ");
				
				l.clickLogin();
				
				Thread.sleep(15000);
				
				APP_LOGS.info("click login");
				
				
				   childTest.get().log(Status.INFO, "click login");
				l.dropdowntheaccount(accnt);
				
				
				 
				Thread.sleep(15000);
				
				APP_LOGS.info("click dropdown ");
				
				   childTest.get().log(Status.INFO, "click dropdown  ");
				
				
				l.clickselect();
				
				Thread.sleep(15000);
				
				   childTest.get().log(Status.INFO, "click select ");
				APP_LOGS.info("click select");
			//	cd.clickArrow();
				
				Thread.sleep(15000);
				
				
				   
				cd.clickSettings();
				
				Thread.sleep(15000);
				
				
				APP_LOGS.info("click setings");
				
				childTest.get().log(Status.INFO, "click setings ");
				
				
				cd.clickCompanyDirectory();
				Thread.sleep(15000);
				
				   childTest.get().log(Status.INFO, "click CD ");
				   
				   
				APP_LOGS.info("click CD");
				
				cd.clickParticipants();
				Thread.sleep(15000);
				
				
				childTest.get().log(Status.INFO, "click Participant ");
				   
				   
				cd.clickuploadparticipantscompany();
				
				Thread.sleep(15000);
				
				childTest.get().log(Status.INFO, "clickuploadparticipantscompany ");
				   
			
				
			BasePage b=new BasePage(driver);
			
			String data=b.preInitialize();
			
			
				b.getDownloadedFileDetails(data);
				Thread.sleep(25000);
				
				
				childTest.get().log(Status.INFO, "Running getDownloadedFileDetails ");
				   
				
				cd.clickDownloadSampleImportTemplate();
				
				Thread.sleep(25000);
				
				
				childTest.get().log(Status.INFO, "clickDownloadSampleImportTemplate");
				   
			
				
			//	b.getLastDownloadedFile("GetLastDownloadedFile");
				
				
				String fileName =b.getLastDownloadedFile("GetLastDownloadedFile");
				
			
				
				childTest.get().log(Status.INFO, "Running GetLastDownloadedFile ");
				   
				
				
				System.out.println("Latest downloaded file is "+fileName);
				
				
				childTest.get().log(Status.INFO, "Latest downloaded file is "+fileName);
			
				
				Thread.sleep(25000);
				
				
				b.addeditTextinExcel(downloadPath, fileName, "Employee File", 0, 2, "charu1");
	
				b.addeditTextinExcel(downloadPath, fileName, "Employee File", 1, 3, "charu2");
				b.addeditTextinExcel(downloadPath, fileName, "Employee File", 2, 4, "charu3");
				
				
				childTest.get().log(Status.INFO, "Running addeditTextinExcel  ");
				
				
				
				  
		}











}
