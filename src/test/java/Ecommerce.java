import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Ecommerce extends TestBase {


    @BeforeMethod
    public void precondition() throws IOException, InterruptedException {
        initProperties();
    }

    @Test
    public void EnterToByShop() {
        enterToShop();
    }

    @Test
    public void assertToastMessage() {

        enterToShop();
        String toastMessage = getToastMessage();
        Assert.assertEquals("Please enter your name", toastMessage);//Actual validation
//name attribute for toast messages will have content
    }

    @Test
    public void buyShoes() {

        enterYourName();
        enterToShop();
        choseItem();
        String lastpageText = checkElementBeforeBuy();
        Assert.assertEquals("Jordan 6 Rings", lastpageText);
    }


    @Test
    public void compareSumOfItems() throws InterruptedException {
        enterYourName();
        enterToShop();
        choseSeveralItems();
        double sum = getSumOfPurchase();
        double totalValue = getTotalSum();
        Assert.assertEquals(sum, totalValue);

    }


    @AfterMethod
    public void postCondition() throws InterruptedException {
        Thread.sleep(5000);
        driver.pressKey(new KeyEvent(AndroidKey.HOME));

    }

}


