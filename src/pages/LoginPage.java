package pages;
import junit.framework.Assert;

import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.Commons;

public class LoginPage {

	public LoginPage() {
		// TODO Auto-generated constructor stub
	}

	public static void loginAsAdmin(WebDriver driver) throws Exception {
		driver.get(Commons.BASE_URL);
	    driver.findElement(By.id("user_login")).sendKeys(Commons.ADMIN_USER_NAME);
	    driver.findElement(By.id("user_pass")).sendKeys(Commons.ADMIN_PASSWORD);
	    driver.findElement(By.cssSelector("p.login-submit > button.subm")).click();
	    //clickIntro(driver);
	    driver.getPageSource().contains("POINTS");
	    driver.getPageSource().contains("Reshufle");
	}

	public static void loginAsPlayer(WebDriver driver, String name) throws Exception {
		driver.get(Commons.BASE_URL);
		/*
		 * Section below was added to avoid unexpected hangs on intro images.
		 * For some reason time to time click on image doesn't work.

		for (int second = 0;; second++) {
			if (second >= 6) {
				System.out.println("timeout");
				driver.findElement(By.cssSelector("img")).click();
				}	
			
			try {
				if ("".equals(driver.findElement(By.id("user_login")).getText())) break; 
				} catch (Exception e) {}
			//Thread.sleep(1000);
			}
		*/
	    driver.findElement(By.id("user_login")).sendKeys(name);
	    driver.findElement(By.id("user_pass")).sendKeys(Commons.USER_PASSWORD);
	    driver.findElement(By.cssSelector("p.login-submit > button.subm")).click();
	    //clickIntro(driver);
	    driver.getPageSource().contains("POINTS");
	    driver.getPageSource().contains("Reshufle");
	}
	public static void loginAsPlayer(WebDriver driver) {
		driver.get(Commons.BASE_URL);
		/* Commented intro section. Intro is not displayed any more
		 * 
		 * 
		 * Section below was added to avoid unexpected hangs on intro images.
		 * For some reason time to time click on image doesn't work.
		 
		for (int second = 0;; second++) {
			if (second >= 6) {
				System.out.println("timeout");
				driver.findElement(By.cssSelector("img")).click();
				}	
			
			try {
				if ("".equals(driver.findElement(By.id("user_login")).getText())) break; 
				} catch (Exception e) {}
			//Thread.sleep(1000);
			}
			*/
	    driver.findElement(By.id("user_login")).sendKeys(Commons.DEFAULT_USER);
	    driver.findElement(By.id("user_pass")).sendKeys(Commons.USER_PASSWORD);
	    driver.findElement(By.cssSelector("p.login-submit > button.subm")).click();
	    //clickIntro(driver); Intro deprecated
	    driver.getPageSource().contains("POINTS");
	    driver.getPageSource().contains("Reshufle");
	}

	public static void logout(WebDriver driver) throws Exception {
		//driver.get(commons.BASE_URL);
	    //clickIntro(driver);
		driver.findElement(By.cssSelector("i.fa.fa-sign-out")).click();
	}

	/**
	 * @param driver
	 */
	public static void clickIntro(WebDriver driver) {
		try {
			
			driver.findElement(By.cssSelector("img")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("img")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("img")).click();
			Thread.sleep(3000);
		} catch (Error | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
