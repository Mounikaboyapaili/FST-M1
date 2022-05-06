package projectActivities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class activity1 {
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        //DesiredCapabilities
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("deviceName","TestEmulator");
        caps.setCapability("appPackage","com.google.android.apps.tasks");
        caps.setCapability("appActivity",".ui.TaskListsActivity");
        caps.setCapability("noReset",true);

        //Server Url
        URL serverUrl= new URL("http://localhost:4723/wd/hub");

        driver= new AndroidDriver<>(serverUrl,caps);
    }

    @Test
    public void googleTask()
    {
        driver.findElementById("tasks_fab").click();
        driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Tasks");
        driver.findElementById("add_task_done").click();

        driver.findElementByAccessibilityId("Create new task").click();
        driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Keep");
        driver.findElementById("add_task_done").click();

        driver.findElementByAccessibilityId("Create new task").click();
        driver.findElementById("add_task_title").sendKeys("Complete the second Activity Google Keep");
        driver.findElementById("add_task_done").click();





    }



}
