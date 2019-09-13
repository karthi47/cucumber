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


public class TariffPlanSteps {
	static WebDriver driver;
	@Given("User on home page")
	public void user_on_home_page() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Karthik durai\\eclipse-workspace\\Facebook1\\driver\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.get("http://demo.guru99.com/telecom/index.html");  
	}

	@When("User enter the tariff details")
	public void user_enter_the_tariff_details(DataTable twodlis) {
		List<List<String>> li2 = twodlis.asLists(String.class);
		driver.findElement(By.xpath("(//a[text()='Add Tariff Plan'])[1]")).click();
		driver.findElement(By.xpath("//input[@id='rental1']")).sendKeys(li2.get(1).get(0));
		driver.findElement(By.xpath("//input[@id='local_minutes']")).sendKeys(li2.get(1).get(1));
		driver.findElement(By.xpath("//input[@id='inter_minutes']")).sendKeys(li2.get(1).get(2));
		driver.findElement(By.xpath("//input[@id='sms_pack']")).sendKeys(li2.get(1).get(3));	
	}

	@When("User enter the remaining tariff details")
	public void user_enter_the_remaining_tariff_details(DataTable twodmap) {
		List<Map<String, String>> ma2 = twodmap.asMaps(String.class,String.class);
		driver.findElement(By.xpath("//input[@id='minutes_charges']")).sendKeys(ma2.get(2).get("LocalperCharge"));
		driver.findElement(By.xpath("//input[@id='inter_charges']")).sendKeys(ma2.get(2).get("InternationalperCharge"));
		driver.findElement(By.xpath("//input[@id='sms_charges']")).sendKeys(ma2.get(2).get("SMSperCharge"));
		driver.findElement(By.xpath("//input[@name='submit']")).click();
	}
	@When("User enter the tariff details {string},{string},{string},{string},{string},{string},{string}")
	public void user_enter_the_tariff_details(String monthly, String local, String Intnl, String freeSMS, String LC, String IC, String SC) {
		driver.findElement(By.xpath("(//a[text()='Add Tariff Plan'])[1]")).click();
		driver.findElement(By.xpath("//input[@id='rental1']")).sendKeys(monthly);
		driver.findElement(By.xpath("//input[@id='local_minutes']")).sendKeys(local);
		driver.findElement(By.xpath("//input[@id='inter_minutes']")).sendKeys(Intnl);
		driver.findElement(By.xpath("//input[@id='sms_pack']")).sendKeys(freeSMS);
		driver.findElement(By.xpath("//input[@id='minutes_charges']")).sendKeys(LC);
		driver.findElement(By.xpath("//input[@id='inter_charges']")).sendKeys(IC);
		driver.findElement(By.xpath("//input[@id='sms_charges']")).sendKeys(SC);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
	}

	@Then("Check weather tariff added successfully.")
	public void check_weather_tariff_added_successfully() {
		WebElement d = driver.findElement(By.xpath("//h2[text()='Congratulation you add Tariff Plan']"));
		String actual = d.getText();
		boolean act = actual.contains("Congratulation");
		Assert.assertTrue(act);
	 
	}
	@Then("Check weather tariff added successfully at a time")
	public void check_weather_tariff_added_successfully_at_a_time() {
		WebElement d = driver.findElement(By.xpath("//h2[text()='Congratulation you add Tariff Plan']"));
		String actual = d.getText();
		boolean act = actual.contains("Congratulation");
		Assert.assertTrue(act);
	 driver.quit();
	}

}
