package utilities;

import Logger.LogSetting;
import org.apache.log4j.Logger;
import org.apache.maven.surefire.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class TakeScreenshot {
    private Logger log = LogSetting.getLogger(TakeScreenshot.class);

    public void screenshotOnFailure(WebDriver myDriver) {
        String screenshotPath = "screenshot" + new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss")
                .format(new GregorianCalendar().getTime())
                + ".png";
        log.info(screenshotPath);
        try {
            File scrFile = ((TakesScreenshot) myDriver)
                    .getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("src/test/resources/Screenshots/" + screenshotPath));
            log.info("Screenshot taken before case failure");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
