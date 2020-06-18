package com.demo.springselenium.googleTests;

import java.io.IOException;

import com.demo.springselenium.SpringBaseTestNGTest;
import com.demo.springselenium.page.google.GooglePage;
import com.demo.springselenium.util.ScreenShotUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest1 extends SpringBaseTestNGTest {

    @Autowired
    private GooglePage googlePage;

    @Autowired
    private ScreenShotUtil screenShotUtil;

    @Test
    public void TC_001() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());

        this.googlePage.getSearchComponent().searchFor("spring boot");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        //this.screenShotUtil.takeScreenShot("GoogleTest1.png");
        
        //this.googlePage.close();
    }

}