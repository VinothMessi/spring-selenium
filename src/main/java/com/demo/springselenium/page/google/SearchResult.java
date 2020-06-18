package com.demo.springselenium.page.google;

import java.util.List;

import com.demo.springselenium.page.Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class SearchResult extends Base {

    @FindBy(xpath = "//div[@class='rc']")
    private List<WebElement> results;

    public int getCount() {
        return this.results.size();
    }

    @Override
    public boolean isAt() {
        return this.myWait.until((d) -> !this.results.isEmpty());
    }

}