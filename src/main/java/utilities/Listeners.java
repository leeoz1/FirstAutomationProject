package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener {
    public void onStart(ITestContext execution) {
        System.out.println("----------------------Starting exceution----------------------");
    }

    public void onFinish(ITestContext execution) {
        System.out.println("----------------------Ending exceution----------------------");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult test) {
//      TODO: implement this...
    }


    public void onTestSkipped(ITestResult test) {
        System.out.println("-------Skipping test------- :" + test.getName() + "-----------");
    }

    public void onTestStart(ITestResult test) {
        System.out.println("-------Starting Test------- :" + test.getName() + "-----------");
    }

    public void onTestSuccess(ITestResult test) {
        System.out.println("-------Test:------- :" + test.getName() + "Passed-----------");

        if (!platform.equalsIgnoreCase("api")) {
            //Stop recording:
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }

            //DELETE recorded file:
            File file = new File("/Users/liozelinger/Documents/Final project/test-recordings/" + test.getName() + ".avi");
            if (file.delete())
                System.out.println("File deleted successfully");
            else
                System.out.println("failed to delete file");
        }
    }

    public void onTestFailure(ITestResult test) {
        System.out.println("-------Test:------- :" + test.getName() + "Failed-----------");
        if (!platform.equalsIgnoreCase("api")) {
            //Stop recording:
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            saveScreenshot();
        }
    }

/*
###########################################################################
Method name : saveScreenshot
Method description : This method returns screenshots in png format (called in method onTestFailure above).
Method parameters : N/A
Method return : array of bytes

Note: Attachment is an allure report annotation,
###########################################################################
*/
    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public byte[] saveScreenshot() {
        if (!platform.equalsIgnoreCase("mobile"))
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        else
            return ((TakesScreenshot) mobileDriver).getScreenshotAs(OutputType.BYTES);
    }
}
