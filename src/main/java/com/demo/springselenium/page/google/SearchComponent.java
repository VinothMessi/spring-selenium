package com.demo.springselenium.page.google;

import java.util.List;

import com.demo.springselenium.page.Base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class SearchComponent extends Base {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private List<WebElement> searchBtns;

    public void searchFor(final String keyWord) {
        this.searchBox.sendKeys(keyWord);
        this.searchBox.sendKeys(Keys.TAB);
        this.searchBtns.stream().filter(e -> e.isDisplayed() && e.isEnabled()).findFirst().ifPresent(WebElement::click);
    }

    @Override
    public boolean isAt() {
        return this.myWait.until((d) -> this.searchBox.isDisplayed());
    }

}