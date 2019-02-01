package mercuryTours;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonActions {
	public static WebDriver register() {
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
		CommonActions.waitSeconds(5);
		driver.findElement(By.name("register")).click();
		CommonActions.waitSeconds(5);
		driver.findElement(ByXPath.xpath("//*[contains(text(), 'SIGN-OFF')]")).click();
		CommonActions.waitSeconds(3);
		return driver;
	}
	public static WebDriver signIn(WebDriver driver) {
		driver.findElement(ByXPath.xpath("//*[contains(text(), 'SIGN-ON')]")).click();
		driver.findElement(By.name("userName")).sendKeys("engineerj123");
		driver.findElement(By.name("password")).sendKeys("testing123");
		driver.findElement(By.name("login")).click();
		return driver;
	}
	public static void waitSeconds(int time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void scrollDown(WebDriver driver, int scroll) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+scroll+")");
		js = null;
	}
	public static void scrollUp(WebDriver driver, int scroll) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+(-scroll)+")");
		js = null;
	}
}
