package generic;



import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.RollingFileAppender;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pulse.Page.HomePage;
import com.pulse.Page.LoginPage;
/*import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;*/
import com.relevantcodes.extentreports.LogStatus;




public abstract class BaseTest  implements IAutoConst{
	

	public   RemoteWebDriver driver=null;
	
	// protected  WebDriver driver1;
	public static int REPEAT_MINUS = 100;
	
Logger APP_LOGS = Logger.getLogger("BaseTest");
     
	
	public static String scrshotFolderLoc;


	  // public static String pathexcel ="C:\\Users\\Admin\\workspace\\PulseProject8\\data\\preCondInput.xlsx";

	
	 static Date d = new Date();
	 
	 
	    static SimpleDateFormat format = new SimpleDateFormat(  "dd.MMMMM.yyyy.hh.mm");
	   

	
	   final static String workingDirexcel = System.getProperty("user.dir");
		
		  //  final static String filePath = "./test-output/MyReport.html";
		  final static String filePathexcel = "\\data\\preCondInput.xlsx";

		  public static String pathexcel =workingDirexcel+filePathexcel;
		
		
		
/*		public static String workingDir = System.getProperty("user.dir");
			
		  //  final static String filePath = "./test-output/MyReport.html";
		public static String filePath = "\\test-output\\MyReport"+format.format(d)+".html";

		  public static String path =workingDir+filePath;*/
		
	
	 BasePage b=new BasePage(driver);
  
	
	static int testRunId=000000;
	
	  public static String logfiletimestamp;

		 
		 public static String downloadPath = null;
		
	//	public  ExtentReports extent;
	//	public  ExtentTest extentTest; 
		
	
	    
	    
		public static  Excel eLib = new Excel();

		
	//	String browserType = eLib.getCellValue(path,"PreCon", 1, 1);
		
		
	//	 int time = Integer.parseInt((eLib.getCellValue(path,"PreCon", 1, 2)).replace(".0", ""));
		
	
		
		
		
		public  ExtentReports extent;
		public    ExtentTest tests; 

		public  ExtentHtmlReporter htmlReporter = null;

		

		
		
		public static ThreadLocal <ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
		public static ThreadLocal<ExtentTest> childTest = new ThreadLocal<ExtentTest>();
		
		
		public  ThreadLocal<RemoteWebDriver > dr= new ThreadLocal<RemoteWebDriver>();
		
	

	
		
		
		@BeforeSuite
		public void beforeSuite(ITestContext context){
			 String suiteName = context.getCurrentXmlTest().getSuite().getName();
			String workingDir = System.getProperty("user.dir");
			
			  //  final static String filePath = "./test-output/MyReport.html";
			String filePath = "\\test-output\\"+suiteName+format.format(d)+".html";

			  String path =workingDir+filePath;
		//	extent = ExtentManager.getExtentReport();

			

			htmlReporter = new ExtentHtmlReporter(workingDir+filePath);
			htmlReporter.config().setReportName("My Test Report");
			htmlReporter.config().setEncoding("utf-8");
			htmlReporter.config().setTheme(Theme.STANDARD);
		//	htmlReporter.config().setTimeStampFormat("mm/dd/yyyy hh:mm:ss a");
			extent = new ExtentReports();
			extent.setSystemInfo("Platform", "Windows");
			extent.attachReporter(htmlReporter);
			
			
			
			
		}
	 
		@BeforeTest
	    public synchronized void beforeClass(XmlTest method) {
	   
		  ExtentTest tests = extent.createTest(method.getName());
		  
			parentTest.set(tests); 
		  
		
		
/*	
		  parentTest = ExtentTestManager
	                .startTest(result.getName() + " " + Thread.currentThread().getName(), "This is a simple test.")
	                .assignCategory(Thread.currentThread().getName());
				
		  parentContext.put(Thread.currentThread().getId(), parentTest);
		  
		  *
		  */
			
			
			
	    }
		
		   @BeforeMethod
	
		
		@Parameters({"browser"})
		
		public void setUp(Method method,String browser) throws Exception 
		
		{
			
			System.out.println("*******************");
			
			 String fileName=null;
			   
	    	 Date d = new Date();
	    	 
	    	 
	 	    SimpleDateFormat format = new SimpleDateFormat(  "dd.MMMMM.yyyy.hh.mm");
	 	   

	 	   logfiletimestamp = "AutomationLog_TestRunId_"+format.format(d);
	 	   
		    System.setProperty("autologname",logfiletimestamp);

		      PropertyConfigurator.configure("Log4j.properties");
		    
        	String browserType = eLib.getCellValue(pathexcel,"PreCon", 1, 1);
	

	
			
			 downloadPath=b.preInitialize();
			 
	       System.out.println("Download Path is:-"+downloadPath);
			 
			 
            DesiredCapabilities dr=null;

            
     	   ExtentTest testmethod = parentTest.get().createNode(method.getName());
		   
		   childTest.set(testmethod);
	
		   
		 
            if(browser.equals("chrome")){
	        	
            	System.out.println("Opening Chrome driver");


			     HashMap<String, Object> chromePrefs = new HashMap<String, Object>();  
			     chromePrefs.put("profile.default_content_settings.popups", 0);  
			     
			     chromePrefs.put("download.default_directory", downloadPath);  
			     chromePrefs.put("safebrowsing.enabled", true);  
			     
			     ChromeOptions options = new ChromeOptions();
			     
		
			     options.setExperimentalOption("prefs", chromePrefs);

		         options.addArguments("--start-maximized");
				

				    DesiredCapabilities capability = DesiredCapabilities.chrome();
				    capability.setBrowserName("chrome");
				    capability.setPlatform(Platform.ANY);

				    capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				    capability.setCapability(ChromeOptions.CAPABILITY, options);
		
	            
				// driver= new RemoteWebDriver(new URL("http://192.168.2.6:4444/wd/hub"), capability);
				 driver=new RemoteWebDriver(new URL("http://10.111.108.157:4444/wd/hub"),capability);
					
	            
	            
	            
	        }
	        else if(browser.equals("firefox")){
	        	
	        	
	        	System.out.println("Opening firefox driver");

				System.setProperty("webdriver.gecko.driver", "C:\\Users\\ssrivastava4\\workspace\\PulseProject8\\driver\\geckodriver.exe");
	
	                   
					 
					FirefoxProfile profile = new FirefoxProfile();
				
					profile.setPreference("browser.download.folderList", 2);
					profile.setPreference("browser.download.manager.showWhenStarting", false);
					profile.setPreference("browser.download.dir", downloadPath);
					
					
	
					
					profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
							"application/vnd.ms-powerpoint,application/vnd.openxmlformats-officedocument.presentationml.presentation");
									
					
					profile.setPreference("browser.helperApps.alwaysAsk.force", false);
					profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
					profile.setPreference("browser.download.manager.focusWhenStarting", false);
					profile.setPreference("browser.download.manager.useWindow", false);
					profile.setPreference("browser.download.manager.showAlertOnComplete", false);
					profile.setPreference("browser.download.manager.closeWhenDone", false);
					 profile.setPreference("network.http.phishy-userpass-length", 255);
			
				
				 DesiredCapabilities capability = new DesiredCapabilities().firefox();
		            capability.setBrowserName("firefox");
		            capability.setPlatform(Platform.WINDOWS);
		            
		         //   DesiredCapabilities capabillities = new DesiredCapabilities("firefox", "3.6.", Platform.WINDOWS);
		            capability.setCapability("job-name", "Fancy Firefox profile");
		      
		            capability.setCapability(FirefoxDriver.PROFILE, profile);
		            


		            driver= new RemoteWebDriver(new URL("http://192.168.2.6:4444/wd/hub"), capability);
	        }
            

		setWebDriver(driver);
		
		getDriver().manage().window().maximize();
		
			getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
			
			}
			
	
		public WebDriver getDriver()
		{
			
			return dr.get();
		}
		
		public void setWebDriver(RemoteWebDriver driver)
		{
			
			dr.set(driver);
		}	
		
		
		
		public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
			
			
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			// after execution, you could see a folder "FailedTestsScreenshots"
			// under src folder
			String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + dateName
					+ ".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
		}

	
		
		

@AfterMethod

	
		
		public void tearDown(ITestResult result) throws IOException
	{
			
		
		
			if(result.getStatus()==ITestResult.FAILURE){
	
			//	 ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed"+ result.getThrowable());
	
				childTest.get().fail(result.getThrowable());
				   	
			//		String imagePath=	getScreenshot(driver,result.getName());
	//	ExtentTestManager.getTest(getClass().getSimpleName()).log(LogStatus.FAIL,ExtentTestManager.getTest(getClass().getSimpleName()).addScreencast(imagePath));   
	
			
			
			
			}
			else if(result.getStatus()==ITestResult.SKIP){
		
				//ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skipped " + result.getThrowable());

				
				childTest.get().skip(result.getThrowable());
				
			}
			
			
			else if(result.getStatus()==ITestResult.SUCCESS){
				
				 //  ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");

				   
				   	
			  //     ExtentTestManager.getTest(getClass().getSimpleName()).log(LogStatus.PASS, "TEST CASE PASSED IS -> "+result.getName());

				
				childTest.get().pass("Test Passed");
				
				
			   	
		//				String imagePath=	getScreenshot(driver,result.getName());
		//	ExtentTestManager.getTest(getClass().getSimpleName()).log(LogStatus.PASS,ExtentTestManager.getTest(getClass().getSimpleName()).addScreencast(imagePath));   
		
			
			
			}
			
		//   parentContext.get(Thread.currentThread().getId()).appendChild(childTest);
	
			//parentTest.appendChild(childTest);
			
		//	parentTest.getRunStatus();
			//childTest.getRunStatus();
	
			//  ExtentManager.getExtentReport().endTest(ExtentTestManager.getTest());        
		   
			
			
			
			
		//	ExtentManager.getExtentReport().flush();
		     
			extent.flush();
		 //       driver.quit();
	
	}
	
	


	
	
@AfterSuite
public void testDown() {
   // extent.flush();
}
@AfterClass
public void afterClass() {
	
	//   ExtentTestManager.closeTest(parentTest);       
  //    ExtentManager.getExtentReport().flush();
    
	
	
      extent.flush();

	driver.quit();
}
			

				
		
	
		
	

		
		
			
}	





