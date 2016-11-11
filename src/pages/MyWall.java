package pages;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;




public class MyWall {
	public static void findCube(WebDriver driver, String id){
		while (driver.getPageSource().contains(id)!=true) {
			//TODO - Add timeout or smth
			clickReshuffle(driver);;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void openCube(WebDriver driver, String id) {
		findCube(driver, id);
		//Open Cube SP
		driver.findElement(By.xpath("//div[@id='profile_cubes_list_item_" + id + "']/div/a")).click();
		//Wait for SP load
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2")));
	}
	

	public static void clickCubeIT(WebDriver driver) throws Exception {
		for (int second = 0;; second++) {
			
			if (second >= Commons.TIMEOUT) {
				fail("Timeout button not found");
			}
			try {
				if (Commons.isElementPresent(driver, By.linkText("Cube"))) break; 
				} catch (Exception e) {}
			Thread.sleep(1000);
		}


		driver.findElement(By.linkText("Cube")).click();
	}
	public static void openEditProfilePage(WebDriver driver) {
		//driver.findElement(By.cssSelector("i.fa.fa-image")).click();
		driver.findElement(By.id("ilm-nav-account")).click();
	}
	public static void openMywall(WebDriver driver) {
		driver.findElement(By.cssSelector("i.fa.fa-user")).click();
		
	}
	public static void clickReshuffle(WebDriver driver) {
		driver.findElement(By.id("ilm-nav-reshuffle")).click();
		
	}
	public static int getCubesNumber(WebDriver driver) {
		return(driver.findElements(By.xpath("//div[@data-is_completed='0']")).size());
	}
	//TODO collect all decks and check them
	public static void getCubesDecks(WebDriver driver) {
			
			driver.findElements(By.xpath("//div[@data-deck]")).equals("deck-2");	
		}
	public static int getUserPoints(WebDriver driver) {
		return Integer.parseInt(driver.findElement(By.id("ilm-points-number")).getText());

	}

}


