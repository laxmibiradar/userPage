package com.crm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.crm.objectRepository.LoginObjectRepo;
import com.utility.ActionUtility;

public class LoginPage extends LoginObjectRepo {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	public String verifyBrowserTitle() {
		return driver.getTitle();

	}
	
	
	public ViewProfilePage verifyValidLogin(WebDriver driver) {
		ActionUtility.clearText(userEmail);
		ActionUtility.clearText(userPass);
		ActionUtility.typeIn(userEmail, "admin");
		ActionUtility.typeIn(userPass, "pass");
		ActionUtility.click(btn);
		return new ViewProfilePage(driver);

	}
}
