package com.TestProject;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import pages.*;

public class sandbox {
	  private WebDriver driver;
	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    
	  }
	// Search using keyword through Google search
	 

		  /*
			try {
			  assertEquals("�If you obey all the rules you miss all the fun.�", driver.findElement(By.cssSelector("em")).getText());
			} catch (Error e) {
			  System.out.println(e.toString());
			}
			try {
				System.out.println(driver.findElement(By.xpath("//span[contains(.,'Miley Cyrus')]")));
				//assertEquals("Miley Cyrus", driver.findElement(By.cssSelector("span.ilm_tester_answer_title")).getText());
			} catch (Error e) {
			  System.out.println(e.toString());}
			
			}
			try {
			  assertEquals("Michelle Obama", driver.findElement(By.cssSelector("li.ilm_tester_answer.answer_4058  > label > span.ilm_tester_answer_title")).getText());
			} catch (Error e) {
			  System.out.println(e.toString());
			}
			try {
			  assertEquals("Oprah", driver.findElement(By.cssSelector("li.ilm_tester_answer.answer_4059  > label > span.ilm_tester_answer_title")).getText());
			} catch (Error e) {
			  System.out.println(e.toString());
			}
			try {
			  assertEquals("Katharine Hepburn", driver.findElement(By.cssSelector("li.ilm_tester_answer.answer_4060  > label > span.ilm_tester_answer_title")).getText());
			} catch (Error e) {
			  System.out.println(e.toString());
			}
			try {
			  assertEquals("", driver.findElement(By.xpath("//input[@value='Answer']")).getText());
			} catch (Error e) {
			  System.out.println(e.toString());
			}
			

	  }*/
	  @Test
	  @Ignore
	  public void sandboxTest() throws Exception {
	      	int i=0;
	      	while (true) {
				LoginPage.loginAsPlayer(driver, "qa_user");
				LoginPage.logout(driver);
				i++;
				System.out.println(i);
			}
	  }
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
	

	// chrometest 
	@Test
	@Ignore
	public void chrometestcase() throws Exception {
		System.setProperty("webdriver.chrome.driver",  "C:/chromedriver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		LoginPage.loginAsPlayer(driver, "ceptuser");
		driver.findElement(By.id("ilm-nav-reshuffle")).click();
		driver.findElement(By.xpath("//article[@id='post-0']/div[3]/div/div/form/div/div[2]/button[2]")).click();
		driver.quit();

	}
}