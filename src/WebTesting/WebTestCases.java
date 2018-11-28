package WebTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebTestCases {
	
	WebDriver driver;
	SoftAssert softAssert;
	
	@BeforeTest 
	public void configurations() {
		System.setProperty("webdriver.chrome.driver", "C:\\Java Projects\\Task2-Web\\third-party-libraries\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		softAssert = new SoftAssert();
	}
	
	@Test (priority=1)
	public void navigateToWeb() {
		driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
		System.out.println("1");
	}
	
	@Test (priority=2)
	public void validateUsersTableDisplayed() {
		driver.findElement(By.cssSelector("table.smart-table")).isDisplayed();
		System.out.println("2");
	}
	
	@Test (priority=3)
	public void showAddScreen() {
		driver.findElement(By.xpath("/html/body/table/thead/tr[2]/td/button")).click();
		System.out.println("3");
	}
	
	@Test  (priority=4)
	public void addUsers() {		
		System.out.println("4");
	}
	
	@AfterTest
	public void closeConnection() {
		driver.quit();
	}
	
	
}
