package app.pivoplay.library;

import app.pivoplay.views.*;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class TestLibrary {

    /*
    * Method for finding element with WebDriverWait
    */
    public AndroidElement findElementByIdWithWait(WebDriver driver, int second, String id) {
        AndroidElement element = (AndroidElement) new WebDriverWait(driver, second)
                .until(ExpectedConditions.elementToBeClickable(MobileBy.id(id)));
        return element;
    }
    public AndroidElement findElementByAccessibilityWithWait(WebDriver driver, int second, String ac_id) {
        AndroidElement element = (AndroidElement) new WebDriverWait(driver, second)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(ac_id)));
        return element;
    }
    public AndroidElement findElementByXpathWithWait(WebDriver driver, int second, String xpath) {
        AndroidElement element = (AndroidElement) new WebDriverWait(driver, second)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath(xpath)));
        return element;
    }

    public AndroidElement findElementByNameWithWait(WebDriver driver, int second, String name) {
        AndroidElement element = (AndroidElement) new WebDriverWait(driver, second)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.name(name)));
        return element;
    }

    public AndroidElement findElementByClassNameWithWait(WebDriver driver, int second, String className) {
        AndroidElement element = (AndroidElement) new WebDriverWait(driver, second)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className(className)));
        return element;
    }

    /*Initialize the app connect with pod etc.*/

    public void connectPod(MobileDriver<AndroidElement> driver) {
        ConnectPodView connectPodView = new ConnectPodView();
        MobileElement connect = connectPodView.getViewElement(driver, "CONNECT");
        //assertTrue("Can not find connect button", connect != null);

        connect.click();

        try {
            Thread.sleep(1000);
        } catch (Exception exp) {
            exp.getMessage();
            exp.getCause();
        }
        CameraView cameraView = new CameraView();
        MobileElement capture = cameraView.getViewElement(driver, "CAPTURE");
        //assertTrue("Cannot find capture button", capture != null);
    }

    public void swipeToRight(AndroidDriver<AndroidElement> driver) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(200, 1000)).waitAction().moveTo(PointOption.point(700, 1000)).release().perform();
    }

    public void swipeToLeft(AndroidDriver<AndroidElement> driver) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(700, 1000)).waitAction().moveTo(PointOption.point(200, 1000)).release().perform();
    }

    /*
   Library for calling global setting view which is using same ID
    */
    public void setAuto(AndroidDriver<AndroidElement> driver) {

        swipeToLeft(driver); // Open setting view
        GlobalSettingView globalSettingView = new GlobalSettingView();
        AndroidElement auto = globalSettingView.getViewElement(driver, "AUTO");
        auto.click();

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(150, 170)).waitAction().moveTo(PointOption.point(800, 170)).release().perform(); //close setting view to confirm change shooting mode

        /* Sometimes confimr button respond 'id does not exist in DOM anymore, so that will use swipe to close the setting
        MobileElement confirm = globalSettingView.getViewElement(driver, "CONFIRM");
        confirm.click();
        */
    }


    public void closeSetting(AndroidDriver<AndroidElement> driver) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(150, 170)).waitAction().moveTo(PointOption.point(800, 170)).release().perform(); //close setting view to confirm change shooting mode
    }


    public void ignoreMessage(AndroidDriver<AndroidElement> driver) {
        NotificationView notificationView = new NotificationView();
        AndroidElement ignore = notificationView.getViewElement(driver, "IGNORE");
        //assertTrue("Can not find ignore button", ignore != null);
        ignore.click();
    }

    public void verifyMakingMagic(AndroidDriver<AndroidElement> driver) {
        PreviewView previewView = new PreviewView();
        AndroidElement back = previewView.getViewElement(driver, "BACK");
        //assertTrue("Can not find back button", back != null);
        back.click();
    }

    public void chooseMode(AndroidDriver<AndroidElement> driver, String elementText) {
        ChooseModeView chooseModeView = new ChooseModeView();
        AndroidElement mode = null;
        switch (elementText){
            case "PANORAMA":
                mode = chooseModeView.getViewElement(driver, "PANORAMA");
                break;
            case "MANY_ME":
                mode = chooseModeView.getViewElement(driver, "MANY_ME");
                break;
            case "FLASH":
                mode = chooseModeView.getViewElement(driver,"FLASH");
                break;
            case "DOUBLE_TAKE":
                mode = chooseModeView.getViewElement(driver,"DOUBLE_TAKE");
                break;
            case "VS":
                mode = chooseModeView.getViewElement(driver,"VS");
                break;
            case "50/50":
                mode = chooseModeView.getViewElement(driver,"50/50");
                break;
            case "TIME_LAPSE":
                mode = chooseModeView.getViewElement(driver, "TIME_LAPSE");
                break;
            case "TINY_PLANET":
                mode = chooseModeView.getViewElement(driver,"TINY_PLANET");
                break;
            case "CLONE_TRAIL":
                mode = chooseModeView.getViewElement(driver, "CLONE_TRAIL");
                break;
        }
        mode.click();

        CameraView cameraView = new CameraView();
        AndroidElement capture = cameraView.getViewElement(driver, "CAPTURE");
        //assertTrue("Cannot find capture button", capture != null);
    }

    public void startCapture(AndroidDriver<AndroidElement> driver){
        CameraView cameraView = new CameraView();
        AndroidElement capture = cameraView.getViewElement(driver, "CAPTURE");
        capture.click();
    }


    public void FlashMode(AndroidDriver<AndroidElement> driver) {
        ChooseModeView chooseModeView = new ChooseModeView();
        AndroidElement flash = chooseModeView.getViewElement(driver,"FLASH");
        //assertTrue("can not find flash", flash != null);
        flash.click();

    }



}