package mercuryTours;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestFlightFinderRoundTrip {
	public static boolean testPage() {
		System.out.println("Testing Flight Finder Round Trip");
		boolean status = false;
		WebDriver driver = CommonActions.register();
		driver = CommonActions.signIn(driver);
		CommonActions.waitSeconds(3);
		driver.findElement(ByXPath.xpath("//*[contains(text(), 'Flights')]")).click();
		driver.findElement(By.cssSelector("input[value='roundtrip']")).click();
		WebElement selectValue = driver.findElement(By.name("passCount"));
		Select select = new Select(selectValue);
		select.selectByValue("2");
		selectValue = driver.findElement(By.name("fromPort"));
		select = new Select(selectValue);
		select.selectByValue("Frankfurt");
		selectValue = driver.findElement(By.name("fromMonth"));
		select = new Select(selectValue);
		select.selectByValue("2");
		selectValue = driver.findElement(By.name("fromDay"));
		select = new Select(selectValue);
		select.selectByValue("10");
		selectValue = driver.findElement(By.name("toPort"));
		select = new Select(selectValue);
		select.selectByValue("London");
		selectValue = driver.findElement(By.name("toMonth"));
		select = new Select(selectValue);
		select.selectByValue("3");
		selectValue = driver.findElement(By.name("toDay"));
		select = new Select(selectValue);
		select.selectByValue("10");
		driver.findElement(By.cssSelector("input[value='Business']")).click();
		selectValue = driver.findElement(By.name("airline"));
		select = new Select(selectValue);
		select.selectByVisibleText("Blue Skies Airlines");
		CommonActions.scrollDown(driver, 300);
		CommonActions.waitSeconds(5);
		driver.findElement(By.name("findFlights")).click();
		List outFlightRadioButton = driver.findElements(By.name("outFlight"));
		boolean radioBtnIsDisplayed = ((WebElement) outFlightRadioButton.get(1)).isDisplayed();
		boolean radioBtnIsEnabled = ((WebElement) outFlightRadioButton.get(1)).isEnabled();
		boolean radioBtnIsSelected = ((WebElement) outFlightRadioButton.get(1)).isSelected();
		((WebElement) outFlightRadioButton.get(1)).click();
		List inFlightRadioButton = driver.findElements(By.name("inFlight"));
		radioBtnIsDisplayed = ((WebElement) inFlightRadioButton.get(2)).isDisplayed();
		radioBtnIsEnabled = ((WebElement) inFlightRadioButton.get(2)).isEnabled();
		radioBtnIsSelected = ((WebElement) inFlightRadioButton.get(2)).isSelected();
		((WebElement) inFlightRadioButton.get(2)).click();
		CommonActions.scrollDown(driver, 300);
		CommonActions.waitSeconds(5);
		driver.findElement(By.name("reserveFlights")).click();
		driver.findElement(By.name("passFirst0")).sendKeys("Jorge");
		driver.findElement(By.name("passLast0")).sendKeys("Ramirez");
		driver.findElement(By.name("passFirst1")).sendKeys("Maria");
		driver.findElement(By.name("passLast1")).sendKeys("Ramirez");
		selectValue = driver.findElement(By.name("creditCard"));
		select = new Select(selectValue);
		select.selectByValue("BA");
		driver.findElement(By.name("creditnumber")).sendKeys("0000000000000000");
		selectValue = driver.findElement(By.name("cc_exp_dt_mn"));
		select = new Select(selectValue);
		select.selectByVisibleText("01");
		selectValue = driver.findElement(By.name("cc_exp_dt_yr"));
		select = new Select(selectValue);
		select.selectByVisibleText("2001");
		driver.findElement(By.name("billAddress1")).sendKeys("Saltillo");
		driver.findElement(By.name("billCity")).sendKeys("Saltillo");
		driver.findElement(By.name("billState")).sendKeys("CO");
		driver.findElement(By.name("billZip")).sendKeys("25000");
		selectValue = driver.findElement(By.name("billCountry"));
		select = new Select(selectValue);
		select.selectByValue("132");
		driver.findElement(By.name("ticketLess")).click();
		CommonActions.scrollDown(driver, 300);
		CommonActions.waitSeconds(5);
		driver.findElement(By.name("buyFlights")).click();
		WebElement element = driver.findElement(ByXPath.xpath("//img[@src='/images/masts/mast_confirmation.gif']"));
		String strValue = element.getAttribute("src");
		if (strValue.equals("http://newtours.demoaut.com/images/masts/mast_confirmation.gif")) {
			System.out.println("Test passed");
			status=true;
		} else {
			System.out.println("Test failed");
			status=false;
		}
		CommonActions.waitSeconds(5);
		driver.findElement(ByXPath.xpath("//img[@src='/images/forms/Logout.gif']")).click();
		CommonActions.waitSeconds(3);
		driver.quit();
		status=true;
		return status;
	}
}