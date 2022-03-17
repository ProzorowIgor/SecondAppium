import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase extends Configuration {
    //static AndroidDriver<AndroidElement>driver;

    public void enterToShop() {

        driver.findElement(By.xpath("//*[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
        //   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));
        driver.findElement(By.xpath("//*[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    }

    public String getToastMessage() {
        String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
        System.out.println(toastMessage);

        return toastMessage;
    }

    public void enterYourName() {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
        driver.hideKeyboard();
    }

    public void choseItem() {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()" +
                ".resourceId(\"com.androidsample.generalstore:id/rvProductList\"))" +
                ".scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));

        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for (int i = 0; i < count; i++) {
            String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (text.equalsIgnoreCase("Jordan 6 Rings")) {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                break;
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
    }

    public String checkElementBeforeBuy(){
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(By.id("com.androidsample.generalstore:id/productName")));
        String lastpageText = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        System.out.println(lastpageText);
        return lastpageText;
    }

    public void choseSeveralItems(){
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
    }

    public double getSumOfPurchase() throws InterruptedException {
        Thread.sleep(4000);
        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
        double sum = 0;
        for (int i = 0; i < count; i++) {
            String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"))
                    .get(i).getText();
            double amount = getAmount(amount1);
            sum = sum + amount;//280.97+116.97
        }
        System.out.println(sum + "sum of products");
        return sum;
    }


    public static double getAmount(String value) {
        value = value.substring(1);
        double amount2value = Double.parseDouble(value);
        return amount2value;
    }

    public double getTotalSum(){
        String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        total = total.substring(1);
        double totalValue = Double.parseDouble(total);
        System.out.println(totalValue + "Total value of products");
        return totalValue;
    }


}
