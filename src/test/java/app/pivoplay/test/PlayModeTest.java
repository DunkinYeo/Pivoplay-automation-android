package app.pivoplay.test;

import app.pivoplay.library.TestLibrary;
import app.pivoplay.views.CloneTrailView;
import app.pivoplay.views.TimeLapseView;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;;
import org.junit.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.*;
import static org.junit.Assert.*;

public class PlayModeTest extends BaseTest {

    @Test(groups = {"Regression"})
    public void PanoramaTest() {

        TestLibrary testLibrary = new TestLibrary();

        testLibrary.connectPod(driver); // connect to pod

        testLibrary.swipeToRight(driver); //open choose mode view

        testLibrary.chooseMode(driver,"PANORAMA");

        testLibrary.startCapture(driver); //Start capture
        testLibrary.ignoreMessage(driver); //ignore message

        try {
            testLibrary.startCapture(driver);
        }catch (Exception exp){
            fail("Can not start capture after ignore the message");
            exp.getCause();
            exp.getMessage();
        }

        testLibrary.verifyMakingMagic(driver); // check capturing is finished
    }

    @Test(groups = {"Regression"})
    public void ManymeTest() {

        TestLibrary testLibrary = new TestLibrary();

        testLibrary.connectPod(driver); // connect to pod

        testLibrary.swipeToRight(driver); //open choose mode view

        testLibrary.chooseMode(driver,"MANY_ME");

        testLibrary.startCapture(driver); //Start capture
        testLibrary.ignoreMessage(driver); //ignore message

        try {
            testLibrary.startCapture(driver);
        }catch (Exception exp){
            fail("Can not start capture after ignore the message");
            exp.getCause();
            exp.getMessage();
        }

        testLibrary.verifyMakingMagic(driver); // check capturing is finished
    }

    @Test(groups = {"Regression"})
    public void FlashTest() {

        TestLibrary testLibrary = new TestLibrary();

        testLibrary.connectPod(driver); // connect to pod

        testLibrary.swipeToRight(driver); //open choose mode view

        testLibrary.chooseMode(driver,"FLASH");

        testLibrary.setAuto(driver); //Set as Auto

        testLibrary.startCapture(driver); //Start capture

        testLibrary.verifyMakingMagic(driver); // check capturing is finished

    }
    @Test(groups = {"Regression"})
    public void DoubleTakeTest(){
        TestLibrary testLibrary = new TestLibrary();

        testLibrary.connectPod(driver); // connect to pod

        testLibrary.swipeToRight(driver); //open choose mode view

        testLibrary.chooseMode(driver,"DOUBLE_TAKE");

        testLibrary.setAuto(driver); //Set as Auto

        testLibrary.startCapture(driver); //Start capture

        testLibrary.verifyMakingMagic(driver); // check capturing is finished

    }

    @Test(groups = {"Regression"})
    public void VSTest(){
        TestLibrary testLibrary = new TestLibrary();

        testLibrary.connectPod(driver); // connect to pod

        testLibrary.swipeToRight(driver); //open choose mode view

        testLibrary.chooseMode(driver,"VS");

        testLibrary.setAuto(driver); //Set as Auto

        testLibrary.startCapture(driver); //Start capture

        testLibrary.verifyMakingMagic(driver); // check capturing is finished
    }

    @Test(groups = {"Regression"})
    public void fiftyFiftyTest(){
        TestLibrary testLibrary = new TestLibrary();

        testLibrary.connectPod(driver); // connect to pod

        testLibrary.swipeToRight(driver); //open choose mode view

        testLibrary.chooseMode(driver,"50/50");

        testLibrary.setAuto(driver); //Set as Auto

        testLibrary.startCapture(driver); //Start capture
        testLibrary.ignoreMessage(driver); //ignore message

        try {
            testLibrary.startCapture(driver);
        }catch (Exception exp){
            fail("Can not start capture after ignore the message");
            exp.getCause();
            exp.getMessage();
        }

        testLibrary.verifyMakingMagic(driver); // check capturing is finished
    }


    @Test(groups = {"Regression"})
    public void timeLapseTest() throws InterruptedException {
        TestLibrary testLibrary = new TestLibrary();

        testLibrary.connectPod(driver);
        testLibrary.swipeToRight(driver);
        testLibrary.chooseMode(driver, "TIME_LAPSE");
        testLibrary.swipeToLeft(driver); //Open setting view

        TimeLapseView timeLapseView = new TimeLapseView();

        AndroidElement slider = timeLapseView.getViewElement(driver, "SLIDER");
        Assert.assertTrue("Can not find SLIDER", slider !=null);
        slider.click(); //Set the degress 360' which is rotate 10minutes.

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(800, 700)).release().perform(); //set the degree as 90' which rotates 2m 30sec

        AndroidElement speedSix = timeLapseView.getViewElement(driver, "SPEED_SIX");
        Assert.assertTrue("Can not find rotation speed button", speedSix != null);
        speedSix.click(); //Set speed to six

        AndroidElement interval = timeLapseView.getViewElement(driver, "INTERVAL_05SEC");
        assertTrue("Can not find interval button", interval != null);
        interval.click(); //Set interval as 0.5 which makes 10.0 sec long footage at the end.

        testLibrary.closeSetting(driver); //close setting to proceed capture

        testLibrary.startCapture(driver); //start capture

        // keep alive appium more than 3 minutes
        for (int i = 0; i < 3; i++) {
            driver.getOrientation(); // execute some command to keep the session alive
            sleep(59*1000); // wake up before session expired
        }

        try {
            testLibrary.verifyMakingMagic(driver); // check capturing is finished
        }catch (Exception exp) {
            fail("Takes more than 90sec to proceed processing after capture");
            exp.getCause();
            exp.getMessage();
        }

    }

    @Test(groups = {"Regression"})
    public void tinyPlanetTest(){
        TestLibrary testLibrary = new TestLibrary();

        testLibrary.connectPod(driver); // connect to pod

        testLibrary.swipeToRight(driver); //open choose mode view

        testLibrary.chooseMode(driver,"TINY_PLANET");

        testLibrary.startCapture(driver); //Start capture
        testLibrary.ignoreMessage(driver); //ignore message

        try {
            testLibrary.startCapture(driver);
        }catch (Exception exp){
            fail("Can not start capture after ignore the message");
            exp.getCause();
            exp.getMessage();
        }

        testLibrary.verifyMakingMagic(driver); // check capturing is finished
    }

    @Test(groups = {"Regression"})
    public void cloneTrailTest() throws InterruptedException {
        TestLibrary testLibrary = new TestLibrary();

        testLibrary.connectPod(driver);
        testLibrary.swipeToRight(driver);
        testLibrary.chooseMode(driver, "CLONE_TRAIL");
        testLibrary.swipeToLeft(driver); //Open setting view

        CloneTrailView cloneTrailView = new CloneTrailView();

        AndroidElement circle = cloneTrailView.getViewElement(driver, "CIRCLE");
        Assert.assertTrue("can not finde circle", circle != null);
        circle.click(); //set degree as 360'

        AndroidElement speedFour = cloneTrailView.getViewElement(driver, "SPEED_FOUR");
        Assert.assertTrue("can not find speed four", speedFour != null);
        speedFour.click(); //set speed as four

        AndroidElement densityLow = cloneTrailView.getViewElement(driver, "DENSITY_LOW");
        Assert.assertTrue("can not find density low button", densityLow != null);
        densityLow.click(); //set density as low

        testLibrary.closeSetting(driver); //close setting to proceed capture

        testLibrary.startCapture(driver); //start capture

        AndroidElement next = cloneTrailView.getViewElement(driver, "NEXT");
        Assert.assertTrue("can not find next button", next != null);

        //click next 3 times
        for (int i = 0; i < 3; i++) {
            next.click();
            Thread.sleep(5000); //wait 5sec wait to proceed next view
        }

        testLibrary.verifyMakingMagic(driver); // check capturing is finished

    }

}
