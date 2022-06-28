package com.cgi.steps;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
WebDriver driver;

	@Given("I have browser with OrangeHRM application")
	public void i_have_browser_with_orange_hrm_application() 
	{
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
	}
	
	@When("I Enter username as {string}")
	public void i_enter_username_as(String username) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
	    
	}
	@When("I Enter password as {string}")
	public void i_enter_password_as(String password) {
		driver.findElement(By.id("txtPassword")).sendKeys(password);
	    
	}
	@When("I Click on Login button")
	public void i_click_on_login_button() {
		driver.findElement(By.id("btnLogin")).click();
	    
	}
	@Then("I should get access to the portal with content as {string}")
	public void i_should_get_access_to_the_portal_with_content_as(String expectedValue) {
		
		boolean Actualstatus=driver.findElement(By.id("welcome")).isDisplayed();
	    Assert.assertEquals("True", Actualstatus);
	}

	@Then("I should get error message as {string}")
	public void i_should_get_error_message_as(String expectedError) {
		String Errormessage = driver.findElement(By.id("spanMessage")).getText();
		Assert.assertEquals(Errormessage, expectedError);
	}

}
