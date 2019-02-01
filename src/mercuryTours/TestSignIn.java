package mercuryTours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

public class TestSignIn {
	public static boolean testPage() {
		System.out.println("Testing SignIn");
		boolean status=false;
		WebDriver driver = CommonActions.register();
		CommonActions.waitSeconds(3);
		driver.findElement(ByXPath.xpath("//*[contains(text(), 'SIGN-ON')]")).click();
		driver.findElement(By.name("userName")).sendKeys("engineerj123");
		driver.findElement(By.name("password")).sendKeys("testing123");
		CommonActions.waitSeconds(3);
		driver.findElement(By.name("login")).click();
		CommonActions.waitSeconds(3);
		driver.findElement(ByXPath.xpath("//*[contains(text(), 'SIGN-OFF')]")).click();
		CommonActions.waitSeconds(3);
		driver.quit();
		status=true;
		return status;
	}
}
