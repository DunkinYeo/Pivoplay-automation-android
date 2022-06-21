package app.pivoplay.utils;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCaps {
    public DesiredCapabilities getDesiredCapabilities(String deviceName, String platformVersion, String udid) {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid",udid);
        capabilities.setCapability("platformVersion",platformVersion);
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage","io.youvr.android.pivo");
        capabilities.setCapability("appActivity","io.youvr.android.pivo.activity.ScanActivity");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("fullReset", "false");
        //capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 350); // newCommandTimeout means How long (in seconds) Appium will wait for a new command from the client before assuming the client quit and ending the session.

        return capabilities;
    }

}
