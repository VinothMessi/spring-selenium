package com.demo.springselenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import io.github.bonigarcia.wdm.WebDriverManager;

@Lazy
@Configuration
@Profile("!remote")
public class WebDriverConfig {

    @Bean
    @Scope("browserscope")
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefox() {
        WebDriverManager.firefoxdriver().version("77.0.1").setup();
        return new FirefoxDriver();
    }

    @Bean
    @Scope("browserscope")
    @ConditionalOnMissingBean
    public WebDriver chrome() {
        WebDriverManager.chromedriver().version("83.0.4103.39").setup();
        return new ChromeDriver();
    }

}