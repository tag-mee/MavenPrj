package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver;

	@Given("I am on the login page")
	public void i_am_on_the_login_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
	   // throw new io.cucumber.java.PendingException();
	}
	@When("I enter valid credentials")
	public void i_enter_valid_credentials() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		WebElement login = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		WebElement pass = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		login.sendKeys("Admin");
		Thread.sleep(3000);
		pass.sendKeys("admin123");
		Thread.sleep(3000);
		
//	    throw new io.cucumber.java.PendingException();
	}
	@When("I click on the login button")
	public void i_click_on_the_login_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		WebElement logBtn = driver.findElement(By.className("oxd-button--main"));
		logBtn.click();
		Thread.sleep(5000);
	  //  throw new io.cucumber.java.PendingException();
	}
	@Then("I should be redirected to the dashboard")
	public void i_should_be_redirected_to_the_dashboard() {
	    // Write code here that turns the phrase above into concrete actions
		String Expected = "Dashboard";
		String Actual = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
		System.out.println("Actual: "+Actual);
		Assert.assertEquals(Expected, Actual,"We are not on the login page");
	  //  throw new io.cucumber.java.PendingException();
	}
	@After
	public void tearDown() {
	    if (driver != null) {
	        driver.quit();
	    }
	}


}
