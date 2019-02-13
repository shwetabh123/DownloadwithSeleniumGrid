package com.pulse.Test;
	import static org.testng.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pulse.Page.Author;
import com.pulse.Page.HomePage;
import com.pulse.Page.LoginPage;

import com.relevantcodes.extentreports.LogStatus;

import generic.BasePage;
import generic.BaseTest;

import generic.Excel;
//import mx4j.log.Log;



//@Listeners(generic.RealGuru99TimeReport.class)


	public class ValidLogin extends BaseTest{

	
		
	//static int teststepcount=000000;
	
	
	public static  Logger APP_LOGS = Logger.getLogger("devpinoyLogger");

	
	static    Excel eLib = new Excel();
	
	  public static String url= eLib.getCellValue(pathexcel,"PreCon", 1, 0);
	
	  public static String logfiletimestamp;
	    
		  
	public static	ITestResult result = null;
		
	
	@Test (description = "This test case is to verify that the firstname and lastname is entered.")
	   //(retryAnalyzer=DynamicRetryAnalyzer.class)
	   
	   // (description = "This test case is to verify that the firstname and lastname is entered.", groups= {"abc"})
	  
	
		public void testValidLogin1(Method method) throws Exception
		
		{
		


			
			driver.get(url);
			
	//	driver.get("http://stg-surveys.cebglobal.com/Pulse");
		
		
			Thread.sleep(15000);

		
			   childTest.get().log(Status.INFO, "Running "+method.getName());
			   
				
			   
			   childTest.get().log(Status.INFO, "Logged into "+url);
			   
			
			   
			   childTest.get().assignCategory("Smoke Testing");
			
			   
			
			
	//		 Randomaplphanumber R=new Randomaplphanumber();
			  
		//	String r=  R.Random();
			
				String un=Excel.getCellValue(XLPATH,"ValidLogin",1,0);
				String pw=Excel.getCellValue(XLPATH,"ValidLogin",1,1);
				String accnt=Excel.getCellValue(XLPATH,"ValidLogin",1,2);
	
				String cb=Excel.getCellValue(XLPATH,"Author",1,3);
				
				
			
		
	    	Logger APP_LOGS = Logger.getLogger(ValidLogin.class);
				

				LoginPage l=new LoginPage(driver);
				

				
				BasePage b=new BasePage(driver);
				

				
				b.openNewTab(driver);
				
				Thread.sleep(15000);
				
				  childTest.get().log(Status.INFO, "opennewtab ");
				  
				b.selectWindow("Pulse Surveys");
				
				Thread.sleep(15000);
				
				  childTest.get().log(Status.INFO, "Select window ");
				
				
				APP_LOGS.info("type username");
				
			
				   
				   childTest.get().log(Status.INFO, "type username ");
				
				l.setUserName(un);
				
				Thread.sleep(15000);

				
	

			
	     	APP_LOGS.info("type password");
	     	  childTest.get().log(Status.INFO, "type password ");
				
				 
				l.setPassword(pw);
				
				Thread.sleep(15000);

	//	        r= BaseTest.getScreenshot(driver, method.getName());
					
					
				  childTest.get().log(Status.INFO, " verify loginbuttondisplayed ");
					
			l.loginbuttondisplayed();
			
			
				APP_LOGS.info("click login");
				
				  childTest.get().log(Status.INFO, "click login ");
					
				
				l.clickLogin();
				
				Thread.sleep(15000);
				
				
	
				
	//	        r= BaseTest.getScreenshot(driver, method.getName());
					

				APP_LOGS.info("click dropdown ");
				
				  childTest.get().log(Status.INFO, "click dropdown ");
					
				
				l.dropdowntheaccount(accnt);
				Thread.sleep(15000);
			
				

					
//			    r= BaseTest.getScreenshot(driver, method.getName());
						

				APP_LOGS.info("click select");

				  childTest.get().log(Status.INFO, "click select ");
		
				l.clickselect();
				Thread.sleep(15000);
				

	//			r = BaseTest.getScreenshot(driver, method.getName());

			
				HomePage h=new HomePage(driver);
				
		  	h.clickArrow();
				
			Thread.sleep(15000);
			  childTest.get().log(Status.INFO, "click arrrow down ");
				
		  	
			APP_LOGS.info("click arrrow down");
				
				h.Logout();
				Thread.sleep(15000);
				
				
			APP_LOGS.info("click logout");
			
			  childTest.get().log(Status.INFO, "click logout ");
				
			
		}
	
	
	@Test (description = "This test case is to verify that the firstname and lastname is entered.")
	 
	
		public void testToolTip(Method method) throws Exception
		
		{
	
				
									
	     
	        String baseUrl = "http://demo.guru99.com/test/social-icon.html";		
	        
	        childTest.get().log(Status.INFO, "Running "+method.getName());
			   
			
			   
			   childTest.get().log(Status.INFO, "Logged into "+baseUrl);
			   
			
			   
			   childTest.get().assignCategory("Smoke Testing");
			
	     					
	        driver.get(baseUrl);					
	        String expectedTooltip = "Github";	
	        
	       
	        childTest.get().log(Status.INFO, "expectedTooltip is :-"+expectedTooltip);
	        
	        Thread.sleep(15000);
	        
	        // Find the Github icon at the top right of the header		
	        WebElement github = driver.findElement(By.xpath(".//*[@class='soc-ico show-round']/a[4]"));	
	        
	        //get the value of the "title" attribute of the github icon		
	        String actualTooltip = github.getAttribute("title");	
	        
	        childTest.get().log(Status.INFO, "Actual Title of Tool Tip"+actualTooltip);
			   
			
	        
	        //Assert the tooltip's value is as expected 		
	        System.out.println("Actual Title of Tool Tip  :- "+actualTooltip);	
	        Thread.sleep(15000);
	        
	        if(actualTooltip.equals(expectedTooltip)) {	
	        	
	        	
	            System.out.println("Test Case Passed");	
	            
	            childTest.get().log(Status.INFO, "expectedTooltip matches with actualTooltip ,Test Case Passed");
	            Thread.sleep(15000);
	        }		
	        driver.close();			
	   }	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

		}










