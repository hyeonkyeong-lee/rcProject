package apptest.apptest;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Rcmp_update {
	
	public AppiumDriver<MobileElement> driver;
	
	    @BeforeTest
	    public void beforeTest()  {
	
	        try {
	        	
	        	DesiredCapabilities cap = new DesiredCapabilities();
	       
	            cap.setCapability("appium-version", "1.19.1"); //UI Automator  사용하기 위함
	            cap.setCapability("automationName", "uiautomator2"); //Android 8.0 이상 필수
	            
	        	cap.setCapability("platformName", "Android");
	        	cap.setCapability("deviceName", "Pixel 4 API 29");  //Phone model number
	        	cap.setCapability("uuid", "emulator-5554");
	        	cap.setCapability("platformVersion", "10.0");
	        	cap.setCapability("appPackage", "com.rsupport.rs.activity.rsupport");
	        	cap.setCapability("appActivity", "com.rsupport.rs.activity.edit.IntroActivity");
	        	cap.setCapability("noReset", "true");

	        	driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	        	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	        	driver.hideKeyboard();        
	        	Thread.sleep(5000);

	        	}catch(Exception exp) {
	        		System.out.println("Cause is : "+exp.getCause());
	        		System.out.println("Cause is : "+exp.getMessage());
	        		exp.printStackTrace();
	        	}
	    }

	  @Test
	  public void NoUpdate() {
		  //업데이트 있을 경우 //업데이트 미실행
		  MobileElement el1 = (MobileElement) driver.findElementById("com.rsupport.rs.activity.rsupport:id/negativeButton");
		  el1.click();
		//MobileElement el2 = (MobileElement) driver.findElementById("com.rsupport.rs.activity.rsupport:id/requestButton");
		 
		  
		 /* if (el2==null) {*/
			  MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("Menu");
			  el4.click();
			  MobileElement el5 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Settings\"]/android.widget.TextView");
			  el5.click();
			  MobileElement el6 = (MobileElement) driver.findElementById("com.rsupport.rs.activity.rsupport:id/serverAddressInputText");
			  el6.clear();
			  el6.sendKeys("stalpa.startsupport.com");
			  MobileElement el7 = (MobileElement) driver.findElementById("com.rsupport.rs.activity.rsupport:id/saveButton");
			  el7.click();
	  }
			  
		/*  }else {
			  el2.click();
			  MobileElement el3 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_button");
			  el3.click();
			  el3.click();
			  MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("Menu");
			  el4.click();
			  MobileElement el5 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Settings\"]/android.widget.TextView");
			  el5.click();
			  MobileElement el6 = (MobileElement) driver.findElementById("com.rsupport.rs.activity.rsupport:id/serverAddressInputText");
			  el6.clear();
			  el6.sendKeys("stalpa.startsupport.com");
			  MobileElement el7 = (MobileElement) driver.findElementById("com.rsupport.rs.activity.rsupport:id/saveButton");
			  el7.click();
		  }		  */

	  @AfterTest
	  public void closeTest() {       
	      driver.quit();
	     }
	}