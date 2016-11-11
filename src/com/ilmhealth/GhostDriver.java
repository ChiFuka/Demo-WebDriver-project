package com.TestProject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.LoginPage;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

/**
 * Created by kostiantyn.kovanov on 2/9/2015.
 */
public class GhostDriver {

    private WebDriver driver;
    @Before
    public void setUp() throws Exception {
        //driver = new FirefoxDriver();

        // prepare capabilities
       /*
        Capabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);                //< not really needed: JS enabled by default
        caps.setCapability("takesScreenshot", true);    //< yeah, GhostDriver haz screenshotz!
        caps.setCapability(
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                "/path/to/your/phantomjs/binary/greater/than/1.7"
        );
        */
        // Launch driver (will take care and ownership of the phantomjs process)
       driver = new PhantomJSDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));

    }


    @Test
    public void loginGhost() throws Exception {
        String url = driver.getCurrentUrl();
        LoginPage.loginAsPlayer(driver);
        // TODO - Error handling
        Assert.assertNotNull(driver.findElement(By.id("ilm-nav-logout")));
        //LoginPage.logout(driver);
        driver.findElement(By.id("ilm-nav-logout")).click();
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}

