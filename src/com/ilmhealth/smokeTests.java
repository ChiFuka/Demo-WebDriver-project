package com.TestProject;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

		import pages.*;

public class smokeTests {
	private static  WebDriver driver;
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();

	}


	@Test
	public void login() throws Exception {
		String url = driver.getCurrentUrl();
		LoginPage.loginAsPlayer(driver);
		// TODO - Error handling
		Assert.assertNotNull(driver.findElement(By.id("ilm-nav-logout")));
		LoginPage.logout(driver);
	}


	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
