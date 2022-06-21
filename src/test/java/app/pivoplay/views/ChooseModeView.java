package app.pivoplay.views;

import app.pivoplay.library.TestLibrary;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ChooseModeView extends TestLibrary {

    private final int SECOND60 = 60;
    private final String TXT_TITLE = "TITLE";
    private final String ID_TITLE = "io.youvr.android.pivo:id/choose_mode_view";
    private final String BTN_CAPTURE = "CAPTURE";
    private final String XPATH_CAPTURE = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.Button";
    private final String BTN_PANORAMA = "PANORAMA";
    private final String XPATH_PANORAMA = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.Button";
    private final String BTN_MANYME = "MANY_ME";
    private final String XPATH_MANYME = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[4]/android.widget.Button";
    private final String BTN_FLASH = "FLASH";
    private final String XPATH_FLASH = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[5]/android.widget.Button";
    private final String BTN_DOUBLETAKE = "DOUBLE_TAKE";
    private final String XPATH_DOUBLETAKE = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[6]/android.widget.Button";
    private final String BTN_VS = "VS";
    private final String XPATH_VS = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[7]/android.widget.Button";
    private final String BTN_50 = "50/50";
    private final String XPATH_50 = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[8]/android.widget.Button";
    private final String BTN_TIMELAPSE = "TIME_LAPSE";
    private final String XPATH_TIMELAPSE = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[9]/android.widget.Button";
    private final String BTN_TINY_PLANET = "TINY_PLANET";
    private final String XPATH_TINY_PLANET = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[11]/android.widget.Button";
    private final String BTN_CLONE_TRAIL = "CLONE_TRAIL";
    private final String XPATH_CLONE_TRAIL = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[14]/android.widget.Button";

    public AndroidElement getViewElement(MobileDriver<AndroidElement> driver, String elementText) {

        AndroidElement element = null;
        switch (elementText) {
            case TXT_TITLE:
                element = findElementByIdWithWait(driver, SECOND60, ID_TITLE);
                break;
            case BTN_CAPTURE:
                element = findElementByXpathWithWait(driver, SECOND60, XPATH_CAPTURE);
                break;
            case BTN_PANORAMA:
                element = findElementByXpathWithWait(driver, SECOND60, XPATH_PANORAMA);
                break;
            case BTN_MANYME:
                element = findElementByXpathWithWait(driver, SECOND60,XPATH_MANYME);
                break;
            case BTN_FLASH:
                element = findElementByXpathWithWait(driver,SECOND60,XPATH_FLASH);
                break;
            case BTN_DOUBLETAKE:
                element = findElementByXpathWithWait(driver, SECOND60, XPATH_DOUBLETAKE);
                break;
            case BTN_VS:
                element = findElementByXpathWithWait(driver, SECOND60,XPATH_VS);
                break;
            case BTN_50:
                element = findElementByXpathWithWait(driver, SECOND60, XPATH_50);
                break;
            case BTN_TIMELAPSE:
                element = findElementByXpathWithWait(driver, SECOND60,XPATH_TIMELAPSE);
                break;
            case BTN_TINY_PLANET:
                element = findElementByXpathWithWait(driver, SECOND60, XPATH_TINY_PLANET);
                break;
            case BTN_CLONE_TRAIL:
                element = findElementByXpathWithWait(driver, SECOND60, XPATH_CLONE_TRAIL);
                break;
        }
        return element;
    }

}
