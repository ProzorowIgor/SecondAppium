import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Configuration {

        Properties properties;
        AndroidDriver<AndroidElement> driver;

        public Configuration(){
            properties = new Properties();
        }




@BeforeSuite
        public void initProperties() throws IOException, InterruptedException {
            String deviceType = System.getProperty("device","emulator");
            String target = System.getProperty("target", "data");
            properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
            String appl = properties.getProperty("apiDemo");
            String device = properties.getProperty("deviceName");
            DesiredCapabilities cap = new DesiredCapabilities();
            File appDir = new File("src/test/resources");
            File app = new File(appDir, appl);

            if (deviceType.equals("emulator")) {
                startEmulator();
                Thread.sleep(6000);
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
            } else if (device.equals("real")) {
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
            }
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");//new step
            cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
           driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }

        public static void startEmulator() throws IOException, InterruptedException
        {
            Runtime.getRuntime().exec("src/test/resources/NewPixel.bat");
            Thread.sleep(6000);
        }


      /*  public String getDevice() {
            return properties.getProperty("device");
        }

        public String getApiDemo() {
            return properties.getProperty("apiDemo");
        }

        public String getDeviceName() {
            return properties.getProperty("deviceName");
        }*/


    }



