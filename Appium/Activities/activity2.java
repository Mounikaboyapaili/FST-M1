package projectActivities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class activity2 {
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        //DesiredCapabilities
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("deviceName","TestEmulator");
        caps.setCapability("appPackage","com.google.android.keep");
        caps.setCapability("appActivity",".activities.BrowseActivity");
        caps.setCapability("noReset",true);

        //Server Url
        URL serverUrl= new URL("http://localhost:4723/wd/hub");

        driver= new AndroidDriver<>(serverUrl,caps);
    }

    @Test
    public void googleKeep()
    {
        driver.findElementByAccessibilityId("New text note").click();
        driver.findElementById("editable_title").sendKeys("FST_Training");

        driver.findElementById("edit_note_text").sendKeys("Training on Selenium,Appium,API testing");
        driver.findElementByAccessibilityId("Open navigation drawer").click();

        MobileElement result= driver.findElementById("index_note_title");
        result.getText();

    }

    @AfterClass
    public void teardown()
    {

        driver.quit();
    }
}
