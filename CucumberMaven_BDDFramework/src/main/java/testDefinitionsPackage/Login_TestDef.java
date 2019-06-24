package testDefinitionsPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_TestDef {
	
	WebDriver driver;
	@Given("user is already on Login Page")
	public void user_is_already_on_Login_Page() {
		System.setProperty("webdriver.chrome.driver", "/home/shanmukh/Python-3.7.3/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.freecrm.com");
		System.out.println("User is in login page");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@When("title of login page is Free CRM")
	public void title_of_login_page_is_Free_CRM() {
		String title = driver.getTitle();
		org.junit.Assert.assertEquals("Free CRM software for any Business", title);
		System.out.println(title);
	}	
	

	@Then("user finds and clicks on login button")
	public void user_finds_and_clicks_on_login_button() {
		driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/div/div[3]/ul/a/span[2]")).click();
//		WebElement button = driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/div/div[3]/ul/a/span[2]"));
//		button.click();
		
	}
	
	@Then("user enters {string} and {string}")
	public void user_enters_and(String username, String password) {
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		
	}
	
	@Then("user clicks on login button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.xpath("//*[@id='ui']/div/div/form/div/div[3]")).click();
//		WebDriverWait wait = new WebDriverWait(driver, 10);
	}
		
	@Then("user is on home page")
	public void user_is_on_home_page() {
		driver.findElement(By.xpath("//*[@id=\'top-header-menu\']")).click();

		
////		String title = driver.getTitle();
////		driver.getClass().getName();
//		String url = driver.getCurrentUrl()
//		org.junit.Assert.assertEquals("raj sn",loginid);
//		System.out.println(title);
		
		
	}
	@Then("user navigates to create contact page")
	public void user_navigates_to_create_contact_page() {
		driver.findElement(By.xpath("//*[@id=\"main-nav\"]")).click();
		driver.switchTo().frame("main-nav");
		driver.findElement(By.xpath("//*[@id=\'main-nav\']/a[3]")).click();
		driver.findElement(By.className("New")).click();
//		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div[2]/div/a/button")).click();
	}

	@Then("user enters contact details {string} and {string} and {string}")
	public void user_enters_contact_details_and_and(String firstname, String lastname, String Company) {
		driver.findElement(By.name("first_name")).sendKeys(firstname);
		driver.findElement(By.name("last_name")).sendKeys(lastname);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/div/input")).sendKeys(Company);
	}

	@Then("user clicks on save")
	public void user_clicks_on_save() {
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div[2]/div/button[2]")).click();

	}

	@Then("^Close the browser$")
	public void close_the_browser() {
		driver.close();
		System.out.println("Test Completed, Browser Closed");
	}

}
