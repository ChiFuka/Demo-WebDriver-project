package pages;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;


public class SlidingPanel {

	public static void radioButtonSelect(WebDriver driver, String answer_id) {
		/*
		 * Select answer (radiobutton) by id
		 */
		 driver.findElement(By.xpath("//input[contains(@data-id," + answer_id +")]")).click();
		  //driver.findElement(By.xpath("//input[@type='radio']")).click();;
	}
	public static void radioButtonSelect(WebDriver driver) {
		/*
		 * Select first radibutton
		 */
		driver.findElement(By.xpath("//input[@type='radio']")).click();
	}
	public static void clickAnswer(WebDriver driver) {
		/*
		 * CLick Answer on SP
		 */
		driver.findElement(By.xpath("//input[@value='Answer']")).click();
		//TODO - change sleep for smth better	
		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void waitForCubeIT(WebDriver driver) {
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Cube-IT")));
	}
	public static void clickCubeITButton(WebDriver driver) {
		 driver.findElement(By.linkText("Cube-IT")).click();
		//TODO - change sleep for smth better	
		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
