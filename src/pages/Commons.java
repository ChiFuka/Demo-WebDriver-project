package pages;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Commons {
	
	public static final String BASE_URL = "http://****:****@qa.TestProject.com/";
	public static final String ADMIN_PASSWORD = "1234567890";
	public static final String ADMIN_USER_NAME = "auto_admin";
	public static final String DEFAULT_USER = "****1711_2"; //user will be used if name is not specified
	public static final String USER_PASSWORD = "1234567890";
	public static final int TIMEOUT = 30; // default timeout 
	public static final int EXPECTED_CUBES_ON_MY_WALL = 6;
	public static final int NUMBER_OR_RESHUFFLES = 3;
	
	//POINTS
	public static final int POINTS_FOR_THE_TIP_UNPERSONAIZED = 10;
	public static final int POINTS_FOR_THE_KNOWLEDGE_TEST_UNPERSONAIZED = 20;

public static void clearUserAnswers(WebDriver driver, String user) throws Exception {
	
	LoginPage.logout(driver);
	LoginPage.loginAsAdmin(driver);
	driver.get(BASE_URL+"/wp/wp-admin/users.php");
	Thread.sleep(500);
	assertEquals("Users Add New", driver.findElement(By.cssSelector("h2")).getText());
	Thread.sleep(500);
	driver.findElement(By.id("user-search-input")).clear();
	driver.findElement(By.id("user-search-input")).sendKeys(user);
	driver.findElement(By.id("search-submit")).click();
	driver.findElement(By.linkText(user)).click();
	Thread.sleep(500);
	driver.findElement(By.linkText("Reset user data")).click();
	Thread.sleep(500);
}

public static boolean isElementPresent(WebDriver driver, By by) {
    try {
        driver.findElement(by);
        return true;
    } catch (NoSuchElementException e) {
        return false;
    }
}


/*
 * This method doesn't work for Players
public static void clearUserAnswers(WebDriver driver) throws Exception {
	
	driver.get("http://qa.TestProject.com/wp/wp-admin/profile.php");
	Thread.sleep(500);
	assertEquals("Profile", driver.findElement(By.cssSelector("h2")).getText());
	Thread.sleep(500);
	driver.findElement(By.linkText("Reset user CUBE-IT data")).click();
	Thread.sleep(500);
}
*/
}
