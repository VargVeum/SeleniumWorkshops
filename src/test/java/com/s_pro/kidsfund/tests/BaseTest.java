package com.s_pro.kidsfund.tests;

import com.s_pro.kidsfund.logging.EventHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected EventFiringWebDriver driver;
    protected String baseUrl = "https://kf-front.scenario-projects.com/";

    @BeforeClass
    public void setUpDriver(){
        //System.setProperty("webdriver.chrome.driver", this.getClass().getResource("/" + getDriverFileName("chrome")).getPath());
        System.setProperty("webdriver.chrome.driver", "/home/tester/Desktop/BaseModel(TestNG)/src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver chromeDriver = new ChromeDriver(options);
        driver = new EventFiringWebDriver(chromeDriver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.register(new EventHandler());

    }

    @AfterClass
    public void tearDownDriver(){
        driver.quit();
    }

    private String getDriverFileName(String browserName){
        String webDriver = null;
        switch(browserName){
            case "chrome":
                webDriver = "chromedriver";
                break;
            default:
                webDriver = "geckodriver";
        }

        String osName = System.getProperty("os.name");
        if (osName.contains("nix"))
            return webDriver;
        if (osName.contains("Windows"))
            return webDriver + ".exe";
        return webDriver;
    }
}
