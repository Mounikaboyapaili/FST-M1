package examples;



import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class firstexampletest<Public> {

    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "RZ8N61B2VHW");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName","Uiautomator2");
        caps.setCapability("appPackage", "com.android.calculator");
        caps.setCapability("appActivity", "calculator");
        caps.setCapability("noRest", "true");

        URL remoteUrl = new URL( "Http://localhost:4723/wd/hub");

        driver =new AndroidDriver<>(remoteUrl, caps);

    }

    @Test
    public void additionTest(){

        MobileElement digit5 = driver.findElementById("digit5");
                digit5.click();
        driver.findElementByAndroidUIAutomator("description(\"plus\")").click();
        digit5.click();
        driver.findElementByAndroidUIAutomator("equals") .click();
        String resultTest = driver.findElementById("result").getText();
        System.out.print(resultTest);


    }

    @AfterClass

    public void tearDown()
    {
        driver.quit();
    }




}
