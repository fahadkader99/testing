package automation.utils;

import automation.utils.DriverUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Random;

public class CommonMethods {

    public static byte[] takeScreenShot(){

        byte[] srcFile = ((TakesScreenshot) DriverUtils.getDriver()).getScreenshotAs(OutputType.BYTES);

        return srcFile;
    }

    public static String generateRandomSSN(){
        int m = (int) Math.pow(10,8);
        int ssn = m+ new Random().nextInt(9 * m);

        return String.valueOf(ssn);

    }


}
