package com.adactin.stepdefinition;

import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class LoginStepCheck {
	static WebDriver driver;
	@Given("User is on home page")
	public void user_is_on_home_page() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Karthik durai\\eclipse-workspace\\Facebook1\\driver\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.get("http://demo.guru99.com/telecom/index.html");
	}

	@When("User enter some valid details")
	public void user_enter_some_valid_details(DataTable lis) {
		List<String> list1 = lis.asList(String.class);
		 driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
		  driver.findElement(By.xpath("//label[text()='Done']")).click();
		  driver.findElement(By.id("fname")).sendKeys(list1.get(0));
		  driver.findElement(By.id("lname")).sendKeys(list1.get(1));
		 }

	@When("User enters remaining details")
	public void user_enters_remaining_details(DataTable ma) {
		Map<String, String> map1 = ma.asMap(String.class, String.class);
		 driver.findElement(By.id("email")).sendKeys(map1.get("email"));
		  driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(map1.get("message"));
		  driver.findElement(By.xpath("//input[@id='telephoneno']")).sendKeys(map1.get("telepone"));
		  driver.findElement(By.xpath("//input[@name='submit']")).click();
		  
	}

	@Then("Verify wheather able to login")
	public void verify_wheather_able_to_login() {
		WebElement d = driver.findElement(By.xpath("//b[text()='Please Note Down Your CustomerID']"));
		String actual = d.getText();
	    Assert.assertEquals("Please Note Down Your CustomerID",actual);
	    driver.quit();
	}
}