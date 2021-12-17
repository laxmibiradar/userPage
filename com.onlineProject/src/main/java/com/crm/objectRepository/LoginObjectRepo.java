package com.crm.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginObjectRepo {
	
	@FindBy(id="LoginForm_username")
	public WebElement userEmail;
	@FindBy(id="LoginForm_password")
	public WebElement userPass;
	@FindBy(xpath="//button")
	public WebElement btn;

}
