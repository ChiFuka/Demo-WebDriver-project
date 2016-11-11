package pages;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

public class UserProfile {

	public static void setReshuflePopUpOff(WebDriver driver) {
		
		//driver.findElement(By.name("do_not_show_reshuffle_notification")).click();

		driver.findElement(By.xpath("(//input[@name='ilm_account[do_not_show_reshuffle_notification]'])")).click();
		driver.findElement(By.xpath("//label[contains(.,'No, hide message')]")).click();
		driver.findElement(By.xpath("//input[@value='Save']")).click();

		//driver.findElement(By.id("profile-group-edit-submit")).click();
				
	}

}
