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

import com.thoughtworks.selenium.webdriven.commands.Click;

public class cubeTests {
	
	
	private static  WebDriver driver;
	@BeforeClass
	  public static void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    LoginPage.loginAsPlayer(driver);
	    MyWall.openEditProfilePage(driver);
	    UserProfile.setReshuflePopUpOff(driver);
	    MyWall.openMywall(driver);
	  }
	
	  @Test
	  public void Card3991() {
		  //LoginPage.loginAsPlayer(driver);
		  MyWall.openCube(driver, "3991");
		  		try {
		  assertEquals("Who said this?", driver.findElement(By.cssSelector("h2")).getText());
				} catch (Error e) {	  System.out.println(e.toString()); fail();	}
		  int points = MyWall.getUserPoints(driver);
		  System.out.println(points);
		  SlidingPanel.radioButtonSelect(driver, "4058");
		  SlidingPanel.clickAnswer(driver);
		  assertTrue(Commons.isElementPresent(driver, (By.xpath("//a[contains(.,'Personalize')]"))));
		  SlidingPanel.waitForCubeIT(driver);
		  assertTrue(driver.getPageSource().contains("Katharine Hepburn."));
		  SlidingPanel.clickCubeITButton(driver);
		  assertTrue((points+Commons.POINTS_FOR_THE_TIP_UNPERSONAIZED)==MyWall.getUserPoints(driver));
		  
	  }

	@Test
	public void Card4016() throws Exception {
	
		//LoginPage.loginAsPlayer(driver);
		int points = MyWall.getUserPoints(driver);
		MyWall.openCube(driver, "4016");
		SlidingPanel.clickCubeITButton(driver);
		try {
			assertTrue((points+Commons.POINTS_FOR_THE_TIP_UNPERSONAIZED)==MyWall.getUserPoints(driver));
		} catch (Error e) {	  System.out.println(e.toString()); fail();	}
		
	}
	@Test
	public void Card3490() throws Exception {
	
		//LoginPage.loginAsPlayer(driver);
		int points = MyWall.getUserPoints(driver);
		MyWall.openCube(driver, "3490");
		SlidingPanel.clickCubeITButton(driver);
		try {
			//assertTrue((points+Commons.POINTS_FOR_THE_TIP_UNPERSONAIZED)==MyWall.getUserPoints(driver));
		} catch (Error e) {	  System.out.println(e.toString()); fail();	}
		
	}
	
	@Test
	@Ignore 
	//TODO This cube is from the deck 2 decide how to reach cubes from other decks
	public void Card3997() throws Exception {
		int points = MyWall.getUserPoints(driver);
		MyWall.openCube(driver, "3997");
		SlidingPanel.clickAnswer(driver);
		try {
			driver.findElement(By.xpath("//span[contains(.,'Please choose an answer.')]"));
		} catch (Error e) {	  System.out.println(e.toString()); fail();	}
		SlidingPanel.radioButtonSelect(driver);
		SlidingPanel.clickAnswer(driver);
		SlidingPanel.clickCubeITButton(driver);
		try {
			assertTrue((points+Commons.POINTS_FOR_THE_KNOWLEDGE_TEST_UNPERSONAIZED)==MyWall.getUserPoints(driver));
		} catch (Error e) {	  System.out.println(e.toString()); fail();	}
		
		
	}
	@Test
	public void Card3872() throws Exception {
		int points = MyWall.getUserPoints(driver);
		MyWall.openCube(driver, "3872");
		SlidingPanel.clickCubeITButton(driver);
		try {
			System.out.println(points);
			System.out.println(MyWall.getUserPoints(driver));
			//assertTrue((points+Commons.POINTS_FOR_THE_KNOWLEDGE_TEST_UNPERSONAIZED) == Integer.parseInt(driver.findElement(By.id("ilm-points-number")).getText()));
			int points2 = MyWall.getUserPoints(driver);
			assertTrue(points == points2);
		} catch (Error e) {	  System.out.println(e.toString()); fail();	}
	}	
	@Test
	public void Card1500() throws Exception {

		MyWall.openCube(driver, "1500");

		try {
			SlidingPanel.clickCubeITButton(driver);
			  //assertEquals("Please upload an image, this is a required step to proceed further", driver.findElement(By.xpath("//div[@id='ilm_hook']/div[3]/div/span")).getText());
		} catch (Error e) {	  System.out.println(e.toString()); fail();	}
		//TODO Add upload test
	}	
	
	
	@After
	  public void tearDown() throws Exception {
		LoginPage.logout(driver);
		driver.quit();
	    
	}
}
