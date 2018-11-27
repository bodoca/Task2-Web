package WebTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebTestCases {
	
	static WebDriver driver;
	static SoftAssert softAssert = new SoftAssert();
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Java Projects\\Task2-Web\\third-party-libraries\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		navigateToTarget();
	}
	
	@Test
	public static void navigateToTarget() {
		softAssert.assertTrue(true);
		driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
		
//		validateUsersTableDisplayed();
	}
	
	@Test
	public static void validateUsersTableDisplayed() {
		
		Boolean isDisplayed = driver.findElement(By.cssSelector("table.smart-table")).isDisplayed();
		
		if(isDisplayed) {
			softAssert.assertTrue(true);
			System.out.println("User list table is displayed");
		}
	}
	
	@Test
	public static void showAddScreen() {
		
		driver.findElement(By.xpath("/html/body/table/thead/tr[2]/td/button")).click();
		
		//check if add screen is displayed
		Boolean addScreenVisible = driver.findElement(By.cssSelector("div.modal-backdrop")).isDisplayed();
		
		if(addScreenVisible) {
			softAssert.assertTrue(true);
			System.out.println("Add screen is displayed");
		}
	}
	
	@Test (dataProvider = "testData")
	public static void addUser(String firstName, String lastName, String username, String password, String customer, String role, String email, String cell) {
		
		showAddScreen();
		
		// enter test data into form fields
		driver.findElement(By.cssSelector("input[name='FirstName']")).sendKeys(firstName);
		driver.findElement(By.cssSelector("input[name='LastName']")).sendKeys(lastName);
		driver.findElement(By.cssSelector("input[name='UserName']")).sendKeys(username);
		driver.findElement(By.cssSelector("input[name='Password']")).sendKeys(password);
		driver.findElement(By.cssSelector("input[name='optionsRadios']")).sendKeys(customer);
		driver.findElement(By.cssSelector("input[name='RoleId']")).sendKeys(role);
		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys(email);
		driver.findElement(By.cssSelector("input[name='Mobilephone']")).sendKeys(cell);
		
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/button[2]")).click();
	}
	
	@DataProvider (name = "testData")
	public Object[][] getData() {
		
		Object[][] testData = new Object[2][8];
		
		testData[0][0] = "FName1";
		testData[0][1] = "LName1";
		testData[0][2] = "User1";
		testData[0][3] = "Pass1";
		testData[0][4] = "Company AAA";
		testData[0][5] = "Admin";
		testData[0][6] = "admin@mail.com";
		testData[0][7] = "082555";/**/
		
		testData[1][0] = "FName2";
		testData[1][1] = "LName2";
		testData[1][2] = "User2";
		testData[1][3] = "Pass2";
		testData[1][4] = "Company BBB";
		testData[1][5] = "Customer";
		testData[1][6] = "customer@mail.com";
		testData[1][7] = "083444";/**/
		
		return testData;
	}
	
}
