package utilities;


import io.appium.java_client.*;

import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;

public class ReusableMethods {

    public static MobileElement scrollUntilElementFound(WebElement targetElementText) {
        AppiumDriver<MobileElement> driver = null; // AppiumDriver'ınızı buraya ekleyin

        while (true) {
            try {
                // Hedef elementi bulmaya çalışın
                MobileElement targetElement = driver.findElement(MobileBy
                        .AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                                + ".scrollIntoView(new UiSelector().textContains(\"" + targetElementText + "\").instance(0))"));

                // Element bulunduysa geri döndür
                return targetElement;

            } catch (Exception e) {
                // Element bulunamadıysa sayfayı aşağı kaydır
                scrollDown(driver);
            }
        }
    }


    public static void scrollDown(AppiumDriver<MobileElement> driver) {
        // Ekranın yarısına kadar kaydırma işlemi
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        int startX = screenWidth / 2;
        int startY = (int) (screenHeight * 0.8); // Ekranın yarısına kadar kaydır

        int endY = (int) (screenHeight * 0.2); // Ekranın en üstüne kadar kaydır

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY)).moveTo(PointOption.point(startX, endY)).release().perform();
    }

    public static void scroll(AppiumDriver driver, int scroll) throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2 ;
        int startY = size.getHeight() / 2 ;
        int endX = startX;
        int endY = (int) (size.getHeight()*0.25);
        //buradaki 0,25 şu şekildedir; imleç ekranın ortasında yani 0,50 de,
        // y ekseninde 0,25 seçtiğimizde 0,50 den 0,25 e çekiyor yani aşağı  kayıyor.
        // Eğer 0,75 deseydik ters yönde  kaydıracaktı. Ne kadar kaydıracağı ise değişiyor.


        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

        for (int i = 0; i <scroll ; i++) {
            Sequence sequence = new Sequence(finger1,1).
                    addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), startX, startY)).
                    addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg())).
                    addAction(new Pause(finger1, Duration.ofMillis(100))).
                    addAction(finger1.createPointerMove(Duration.ofMillis(300),PointerInput.Origin.viewport(),endX,endY)).
                    addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(sequence));}
        Thread.sleep(3000);
    }

    //ikinci alternatif bir method

    public static void wait(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getAppiumDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    public static void touchAction(int a,int b,int c,int d) {

        TouchAction action = new TouchAction<>((PerformsTouchActions) Driver.getAppiumDriver());
        action.press(PointOption.point(a, b))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(c, d)).release().perform();
    }
    public static void touchActionClick(int a,int b) {

        TouchAction action = new TouchAction<>((PerformsTouchActions) Driver.getAppiumDriver());
        action.press(PointOption.point(a, b))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .release().perform();
    }


    public static void koordinatTiklama(int xDegiskeni,int yDegiskeni,int bekleme) throws InterruptedException {
        TouchAction action=new TouchAction<>((PerformsTouchActions) Driver.getAppiumDriver());
        action.press(PointOption.point(xDegiskeni,yDegiskeni)).release().perform();
        Thread.sleep(bekleme);
    }

    public static void screenScroll(int xPress,int yPress,int wait,int moveX,int moveY){
        TouchAction action=new TouchAction<>((PerformsTouchActions) Driver.getAppiumDriver());
        action.press(PointOption.point(xPress,yPress))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(moveX,moveY))
                .release()
                .perform();
    }

    public static void screenScrollDown(int wait){
        TouchAction action=new TouchAction<>((PerformsTouchActions) Driver.getAppiumDriver());
        action.press(PointOption.point(471,1371))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(471,186))
                .release()
                .perform();
    }

    public static void screenScrollUp(int wait){
        TouchAction action=new TouchAction<>((PerformsTouchActions) Driver.getAppiumDriver());
        action.press(PointOption.point(1052,1016))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(31,1016))
                .release()
                .perform();
    }
    // 1052,1016 31,1016
    public static void screenScrollRight(int wait) {
        TouchAction action = new TouchAction<>((PerformsTouchActions) Driver.getAppiumDriver());
        action.press(PointOption.point(1052, 1016))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(31, 1016))
                .release()
                .perform();
    }

    public static void screenScrollLeft(int wait) {
        TouchAction action = new TouchAction<>((PerformsTouchActions) Driver.getAppiumDriver());
        action.press(PointOption.point(31, 1016))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(1052, 1016))
                .release()
                .perform();
    }



    public static String getScreenshot2(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot)Driver.getAppiumDriver();

        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }
}
