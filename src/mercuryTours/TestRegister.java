package mercuryTours;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

// Test class for Mercury Tools register page: http://newtours.demoaut.com/
public class TestRegister {
	public static boolean testPage() {
		System.out.println("Testing Register");
		boolean status = false;
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\41889\\eclipse-workspace\\mercury-tours-selenium-testing\\libs\\Selenium-Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String baseUrl="http://newtours.demoaut.com/";

		driver.get(baseUrl);
		CommonActions.waitSeconds(3);
		driver.findElement(ByXPath.xpath("//*[contains(text(), 'REGISTER')]")).click();
		driver.findElement(By.name("firstName")).sendKeys("Jorge");
		driver.findElement(By.name("lastName")).sendKeys("Ramirez");
		driver.findElement(By.name("phone")).sendKeys("5578104807");
		driver.findElement(By.name("userName")).sendKeys("engineer_j123@hotmail.com");
		driver.findElement(By.name("address1")).sendKeys("Saltillo");
		driver.findElement(By.name("city")).sendKeys("Saltillo");
		driver.findElement(By.name("state")).sendKeys("Coahuila de Zaragoza");
		driver.findElement(By.name("postalCode")).sendKeys("25000");
		driver.findElement(By.name("country")).sendKeys("MEXICO");
		driver.findElement(By.name("email")).sendKeys("engineerj123");
		driver.findElement(By.name("password")).sendKeys("testing123");
		driver.findElement(By.name("confirmPassword")).sendKeys("testing123");
		CommonActions.scrollDown(driver, 300);
		CommonActions.waitSeconds(5);
		driver.findElement(By.name("register")).click();
		CommonActions.waitSeconds(5);
		driver.findElement(ByXPath.xpath("//*[contains(text(), 'SIGN-OFF')]")).click();
		CommonActions.waitSeconds(3);
		driver.quit();
		status=true;
		return status;
	} 
}
