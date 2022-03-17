import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;




public class ScrollBasic extends Configuration {
  //  AndroidDriver<AndroidElement> driver;
    // IT IS APLICABLE ONLY TO THE NODE JS
 /*   @BeforeTest
    public void killAllNodes() throws IOException, InterruptedException
    {
        //taskkill /F /IM node.exe
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(3000);

    }*/

    @Test
    public void scrollTest() {

      //  AndroidDriver<AndroidElement> driver = capabilities(deviceName);
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Views']")));
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
        //   service.stop();
    }

    




}