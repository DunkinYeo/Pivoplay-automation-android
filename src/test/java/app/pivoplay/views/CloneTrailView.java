package app.pivoplay.views;

import app.pivoplay.library.TestLibrary;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CloneTrailView extends TestLibrary {

    private final int SECOND60 = 60;

    //@AndroidFindBy(id = "io.youvr.android.pivo:id/circle_view")
    private final String ID_CIRCLE = "io.youvr.android.pivo:id/circle_view";
    private final String BTN_CIRCLE = "CIRCLE";

    //@AndroidFindBy(id = "io.youvr.android.pivo:id/btn_1d")
    private final String ID_DENSITY_LOW = "io.youvr.android.pivo:id/btn_1d";
    private final String BTN_DENSITY_LOW = "DENSITY_LOW";

    //@AndroidFindBy(id = "io.youvr.android.pivo:id/btn_4")
    private final String ID_SPEED_FOUR = "io.youvr.android.pivo:id/btn_4";
    private final String BTN_SPEED_FOUR = "SPEED_FOUR";

    //@AndroidFindBy(id = "io.youvr.android.pivo:id/btn_done")
    private final String ID_NEXT = "io.youvr.android.pivo:id/btn_done";
    private final String BTN_NEXT = "NEXT";



    public AndroidElement getViewElement(AndroidDriver<AndroidElement> driver, String elementText) {
        AndroidElement element = null;

        switch(elementText) {
            case BTN_CIRCLE:
                element = findElementByIdWithWait(driver, SECOND60, ID_CIRCLE);
                break;
            case BTN_SPEED_FOUR:
                element = findElementByIdWithWait(driver, SECOND60, ID_SPEED_FOUR);
                break;
            case BTN_DENSITY_LOW:
                element = findElementByIdWithWait(driver, SECOND60, ID_DENSITY_LOW);
                break;
            case BTN_NEXT:
                element = findElementByIdWithWait(driver, SECOND60, ID_NEXT);
                break;
        }
        return element;
    }

}
