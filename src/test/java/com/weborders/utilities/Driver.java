package com.weborders.utilities;
// design pattern
// how everything should be designed
// for all oop languages, how to resolve common issues --best practices

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
    // reference variable, pointer on object
    // if reference variable doesn't point on any object it will have a null value
    // whenever we type new Class()-- we create a new object
    // reference type can be class, parent class, or interface implemented by class or parent class
    //since WebDriver is an interface implemented by RemoteWebDrive class
    // and RemoteWebDriver is a parent class or ChromeDriver, FirefoxDriver, etc, classes
    // we can specify reference type as a WebDriver
    // it helps to define object type in a run time (polymorphism)



    private static WebDriver driver;

    private Driver(){}

    public static WebDriver getDriver(){

        if(driver==null){
            String browser = "chrome";
            switch (browser){
                case"chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case"firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Browser is not implemented yet: " + browser);
            }
        }
        return driver;
    }
}
