package app.pivoplay.test;

import app.pivoplay.utils.DesiredCaps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.URL;

public abstract class BaseTest {

    public AndroidDriver<AndroidElement> driver;
    private static AppiumDriverLocalService service;
    private final DesiredCaps desiredCaps = new DesiredCaps();

    @BeforeSuite(groups = {"abstract"})
    public void globalSetup() throws IOException {
        System.out.println("Starting BeforeSuite...");

        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }

    @BeforeMethod(groups = {"abstract"})
    @Parameters({"deviceName", "platformVersion", "udid", "noReset"})
    public void setUp(String deviceName, String platformVersion, String udid, boolean noReset) throws IOException {
        System.out.println("BeforeMethod...");
        DesiredCapabilities caps = desiredCaps.getDesiredCapabilities(deviceName, platformVersion, udid, noReset);

        try {
            driver = new AndroidDriver<io.appium.java_client.android.AndroidElement>(getServiceUrl(), caps);
        } catch (Exception exp) {
            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }
    }


    @AfterMethod(groups = { "abstract" })
    public void tearDown() {
        System.out.println("AfterMethod...");
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite(groups = { "abstract" })
    public void globalTearDown() {
        System.out.println("AfterSuite...");

        if (service != null) {
            service.stop();
        }
    }
    public URL getServiceUrl () {
        return service.getUrl();
    }
}

