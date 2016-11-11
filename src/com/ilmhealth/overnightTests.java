package com.TestProject;

import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.*;

import com.thoughtworks.selenium.webdriven.commands.Click;

public class overnightTests {
	private  WebDriver driver;
	@Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	  }
	@Test
	  public void numberOfCubesOnMyWall() throws Exception {
	      /*
	       * Verify that after each reshuffle user gets exactly 6 cubes/cards on the wall
	       */
		  LoginPage.loginAsPlayer(driver, "qa_user");
	      MyWall.openEditProfilePage(driver);
	      UserProfile.setReshuflePopUpOff(driver);
	    
	      MyWall.openMywall(driver);
		  for (int i = 0; i < Commons.NUMBER_OR_RESHUFFLES; i++) {
	      	MyWall.clickReshuffle(driver);
	      	System.out.println(i);
	      	try {
	      		Assert.assertEquals("Unsolved cubes on the wall", Commons.EXPECTED_CUBES_ON_MY_WALL, MyWall.getCubesNumber(driver));
	      	} catch (Error e) {
	      		System.out.println(e.getMessage());
	      		fail();
	      		}
		  }

	  }
	  @Test
	  public void numberOfCubesOnMyWallwithRelogin() throws Exception {
	      /*
	       * Verify that after each reshuffle user gets exactly 6 cubes/cards on the wall after each login
	       */
		  LoginPage.loginAsPlayer(driver, "qa_user");
	      MyWall.openEditProfilePage(driver);
	      UserProfile.setReshuflePopUpOff(driver);
	      LoginPage.logout(driver);
	      
		  for (int i = 0; i < Commons.NUMBER_OR_RESHUFFLES; i++) {
			  	LoginPage.loginAsPlayer(driver, "qa_user");
				MyWall.clickReshuffle(driver);
			  try {
				
				Assert.assertEquals(Commons.EXPECTED_CUBES_ON_MY_WALL, MyWall.getCubesNumber(driver));
				
				} catch (Exception e) {
				System.out.println(e.getMessage());
	      		fail();		}
			  LoginPage.logout(driver);
			  
		  	}

	  	}

		@After
		  public void tearDown() throws Exception {
		    driver.quit();
		  }
}
