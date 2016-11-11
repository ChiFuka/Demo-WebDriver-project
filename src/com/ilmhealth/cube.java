package com.TestProject;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.*;


public class cube {
  private WebDriver driver;
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
  }


  @Test
  public void testtestclass() throws Exception {


	  LoginPage.loginAsAdmin(driver);
	  MyWall.openEditProfilePage(driver);
	  UserProfile.setReshuflePopUpOff(driver);
	  MyWall.openMywall(driver);
	  String id="3583";
	  Thread.sleep(1000);
	  driver.get("http://qa.TestProject.com/members/auto_admin/mywall/?item_id=" + id);
	  Thread.sleep(2000);
	  MyWall.openCube(driver, id);
	  Thread.sleep(1000);
	  
  try {
	  assertEquals("Quick poll:", driver.findElement(By.cssSelector("h2")).getText());
	  assertEquals("When you find yourself on your own, how does it feel?", driver.findElement(By.cssSelector("p")).getText());
	  assertEquals("Energizing; so much to do, so little time.", driver.findElement(By.cssSelector("li.ilm_tester_answer.answer_5660  > label > span.ilm_tester_answer_title")).getText());
	  assertEquals("Boring; I don't know what to do by myself.", driver.findElement(By.cssSelector("li.ilm_tester_answer.answer_5661  > label > span.ilm_tester_answer_title")).getText());
	  assertEquals("Scary; I hate being alone.", driver.findElement(By.cssSelector("li.ilm_tester_answer.answer_5662  > label > span.ilm_tester_answer_title")).getText());
	  assertEquals("", driver.findElement(By.xpath("//input[@value='Answer']")).getText());
} catch (Exception e) {
	// TODO Auto-generated catch block
	fail("Cube content has changed or SP was not opened");
	e.printStackTrace();
	
}
    
  //Solve the cube 
  try {
	driver.findElement(By.cssSelector("li.ilm_tester_answer.answer_5660  > label > input[name=\"ilm_tester[ilm_test][values]\"]")).click();
	  driver.findElement(By.xpath("//input[@value='Answer']")).click();
	  Thread.sleep(5000);
	  assertEquals("Thanks for your input!", driver.findElement(By.cssSelector("p.answer-notes")).getText());
	  assertEquals("Personalize", driver.findElement(By.linkText("Personalize")).getText());
	  assertEquals("Cube-IT", driver.findElement(By.linkText("Cube-IT")).getText());
	  driver.findElement(By.linkText("Cube-IT")).click();
	  Thread.sleep(5000);
	  assertTrue(driver.getPageSource().contains("<span>10</span>"));
	 
} catch (Exception e) {
	// TODO Auto-generated catch block
	fail("Cube solving failed or cube was already solved");
	e.printStackTrace();
}

//Clear user data
  try {
	driver.get("http://qa.TestProject.com/wp/wp-admin/profile.php");
	  assertEquals("Profile", driver.findElement(By.cssSelector("h2")).getText());
	  driver.findElement(By.linkText("Reset user CUBE-IT data")).click();
	  Thread.sleep(500);
} catch (Exception e) {
	// TODO Auto-generated catch block
	fail("User data was not cleared");
	e.printStackTrace();
}
	  }


  @After
  public void tearDown() throws Exception {
    driver.quit();
  }
}