package apptest.apptest;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Rcmp_setting {
	
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
	  public void sampleTest() {
		  //앱 권한 획득 전(최초 실행)
		  /*MobileElement el1 = (MobileElement) driver.findElementById("com.rsupport.rs.activity.rsupport:id/requestButton");
		  el1.click();
		  MobileElement el2 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_button");
		  el2.click();
		  el2.click();
		  MobileElement el4 = (MobileElement) driver.findElementById("android:id/switch_widget");
		  el4.click();
		  MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
		  el5.click();
		  MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[8]/android.widget.RelativeLayout");
		  el6.click();*/
		  
		  //앱 권한 획득 후
		  MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId("Menu");
		  el7.click();
		  MobileElement el8 = (MobileElement) driver.findElementByAccessibilityId("Settings");
		  el8.click();
		  MobileElement el9 = (MobileElement) driver.findElementById("com.rsupport.rs.activity.rsupport:id/serverAddressInputText");
		  el9.clear();
		  el9.sendKeys("stalpa.startsupport.com");
		  MobileElement el10 = (MobileElement) driver.findElementById("com.rsupport.rs.activity.rsupport:id/saveButton");
		  el10.click();
		  MobileElement el11 = (MobileElement) driver.findElementByAccessibilityId("Menu");
		  el11.click();
		  MobileElement el12 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"About\"]/android.widget.TextView");
		  el12.click();
		  MobileElement el13 = (MobileElement) driver.findElementById("com.rsupport.rs.activity.rsupport:id/titleText");
		  el13.click();
		  MobileElement el14 = (MobileElement) driver.findElementByAccessibilityId("Back");
		  el14.click();
		  MobileElement el15 = (MobileElement) driver.findElementByAccessibilityId("Menu");
		  el15.click();
		  MobileElement el16 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"End mobile support\"]/android.widget.TextView");
		  el16.click();
	      }

	  @AfterTest
	  public void closeTest() {       
	      driver.quit();
	     }
	}