package testDefinitionsPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		System.out.println("login page title: " + title);
	}	
	

	@Then("user finds and clicks on login button")
	public void user_finds_and_clicks_on_login_button() {
		driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
//		WebElement button = driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/div/div[3]/ul/a/span[2]"));
//		button.click(); v[1]/header/div/nav/div[2]/div/div[3]/ul/a/span[2]
		
	}
	
	@Then("user enters {string} and {string}")
	public void user_enters_and(String username, String password) {
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		
	}
	
	@Then("user clicks on login button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
//		abs path :/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]
		// WebDriverWait wait = new WebDriverWait(driver, 10);
	}
		
	@Then("user is on home page")
	public void user_is_on_home_page() {
		String pagetitle = driver.getTitle();
		org.junit.Assert.assertEquals("CRM", pagetitle);
		System.out.println("After Login page title:" + pagetitle);
		WebElement loggedUser = driver.findElement(By.xpath("//span[@class='user-display']"));
		org.junit.Assert.assertEquals(loggedUser.getText(), "raj sn");		
		
	}
	@Then("user navigates to create contact page")
	public void user_navigates_to_create_contact_page() {
		driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'New')]")).click();
	}

	@Then("user enters contact details {string} and {string} and {string}")
	public void user_enters_contact_details_and_and(String firstname, String lastname, String Company) {
		driver.findElement(By.name("first_name")).sendKeys(firstname);
		driver.findElement(By.name("last_name")).sendKeys(lastname);
		driver.findElement(By.xpath("//div[@name='company']//input[@class='search']")).sendKeys(Company);
	}

	@Then("user clicks on save")
	public void user_clicks_on_save() {
		driver.findElement(By.xpath("//button[@class='ui linkedin button']")).click();

	}

	@Then("^Close the browser$")
	public void close_the_browser() {
		driver.close();
		System.out.println("Test Completed, Browser Closed");
	}

}
