package com.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNg extends Base {
	

	@Test(dataProvider="res")
	private void login(String name,String lName,String address,String email,String phno,String pass,String confirm) {
		
		System.out.println(name);
		System.out.println(lName);
		System.out.println(email);
		System.out.println(phno);
		System.out.println(pass);
		System.out.println(confirm);
	}

	@DataProvider(name = "res")
	public Object[][] data() throws Throwable {

		return getData();

	}

}

