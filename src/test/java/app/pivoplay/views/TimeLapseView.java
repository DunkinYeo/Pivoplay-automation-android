package app.pivoplay.views;

import app.pivoplay.library.TestLibrary;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TimeLapseView extends TestLibrary {

    private final int SECOND60 = 60;

    //@AndroidFindBy(id= "io.youvr.android.pivo:id/circular_slider_view")
    private final String ID_SLIDER = "io.youvr.android.pivo:id/circular_slider_view";
    private final String BTN_SLIDER = "SLIDER";

    //@AndroidFindBy(id= "io.youvr.android.pivo:id/btn_6_sec")
    private final String ID_SPEED_SIX = "io.youvr.android.pivo:id/btn_6_sec";
    private final String BTN_SPEED_SIX = "SPEED_SIX";

    //@AndroidFindBy(id="io.youvr.android.pivo:id/btn_int_05_sec")

    private final String ID_INTERVAL_05SEC = "io.youvr.android.pivo:id/btn_int_05_sec";
    private final String BTN_INTERVAL_05SEC = "INTERVAL_05SEC";


    public AndroidElement getViewElement(MobileDriver<AndroidElement> driver, String elementText) {

        AndroidElement element = null;

        switch(elementText){
            case BTN_SLIDER:
                element = findElementByIdWithWait(driver,SECOND60, ID_SLIDER);
                break;
            case BTN_SPEED_SIX:
                element = findElementByIdWithWait(driver, SECOND60, ID_SPEED_SIX);
                break;
            case BTN_INTERVAL_05SEC:
                element = findElementByIdWithWait(driver, SECOND60, ID_INTERVAL_05SEC);
                break;
        }
        return element;
    }

    }
