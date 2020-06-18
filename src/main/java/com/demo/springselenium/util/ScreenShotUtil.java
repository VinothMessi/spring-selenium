package com.demo.springselenium.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

@Component
public class ScreenShotUtil {

    @Autowired
    private TakesScreenshot driver;

    @Value("${screenShotPath}")
    private String path;

    public void takeScreenShot(final String imageName) throws IOException {
        File srcFile = this.driver.getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(srcFile, new File(path + imageName));
    }

}