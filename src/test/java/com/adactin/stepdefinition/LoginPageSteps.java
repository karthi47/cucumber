package com.adactin.stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginPageSteps {
	WebDriver driver;
	@Given("User Enter the  and Select the Gender and Hobbies")
	public void user_Enter_the_and_Select_the_Gender_and_Hobbies(io.cucumber.datatable.DataTable data) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Karthik durai\\eclipse-workspace\\Facebook1\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		List<String> x = data.asList();
		
		driver.get("http://demo.automationtesting.in/Register.html");
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(x.get(0));
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(x.get(1));
		driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys(x.get(2));
		driver.findElement(By.xpath("//input[@ng-model='EmailAdress']")).sendKeys(x.get(3));
		driver.findElement(By.xpath("//input[@ng-model='Phone']")).sendKeys(x.get(4));
		}

	@When("User Enter the details")
	public void user_Enter_the_details(io.cucumber.datatable.DataTable data2) {
		List<String> x1 = data2.asList();
		driver.findElement(By.xpath("(//input[@ng-model='radiovalue'])[2]")).click();
		driver.findElement(By.xpath("//input[@id='checkbox2']")).click();
		driver.findElement(By.xpath("//div[@id='msdd']")).click();
		driver.findElement(By.xpath("//label[text()='Skills']")).click();
		WebElement skill=driver.findElement(By.xpath("//select[@id='Skills']"));
		Select s=new Select(skill);
		s.selectByVisibleText("Engineering");
		WebElement country1=driver.findElement(By.xpath("//label[text()='Country*']"));
		country1.click();
		WebElement country=driver.findElement(By.xpath("//select[@id='countries']"));
		Select s1=new Select(country);
		s1.selectByVisibleText("India");
		country1.click();
		WebElement scountry=driver.findElement(By.xpath("//select[@id='countries']"));
		Select s7=new Select(scountry);
		s7.selectByVisibleText("India");
		WebElement dyear=driver.findElement(By.xpath("//select[@id='yearbox']"));
		Select s2=new Select(dyear);
		s2.selectByVisibleText("1993");
		WebElement dmonth=driver.findElement(By.xpath("//select[@ng-model='monthbox']"));
		Select s3=new Select(dmonth);
		s3.selectByVisibleText("April");
		WebElement ddate=driver.findElement(By.xpath("//select[@ng-model='daybox']"));
		Select s4=new Select(ddate);
		s4.selectByVisibleText("25");
		WebElement password=driver.findElement(By.xpath("//input[@id='firstpassword']"));
		password.sendKeys(x1.get(5));
		WebElement confirmpassword=driver.findElement(By.xpath("//input[@id='secondpassword']"));
		confirmpassword.sendKeys(x1.get(6));
		}
@Then("click on the Summit button and check WebTable is in the url")
	public void click_on_the_Summit_button_and_check_WebTable_is_in_the_url() {
		WebElement sum=driver.findElement(By.xpath("//button[@id='submitbtn']"));
		sum.click();
		String url=driver.getCurrentUrl();
		boolean b=url.contains("automationtesting");
		Assert.assertTrue(b);   
	}



	}
	




