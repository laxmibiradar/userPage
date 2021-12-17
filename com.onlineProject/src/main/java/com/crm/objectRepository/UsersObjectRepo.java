package com.crm.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersObjectRepo {
	WebDriver driver;
	@FindBy(xpath="//a[text()='Users']")
	public WebElement userLink ;
	@FindBy(xpath="//*[@class='portlet-title ui-sortable-handle']")
	public List<WebElement> menu ;
	@FindBy(xpath="//i[@title='Actions']")
	public WebElement Actdropdown;
	@FindBy(xpath="//img")
	public WebElement logo ;
	@FindBy(xpath="//th")
	public List <WebElement> header ;
	@FindBy(xpath="//*[text()='Yes']")
	public List<WebElement> activeUser ;	
	@FindBy(xpath="//*[@id='User_firstName']")
	public WebElement firstName;
	@FindBy(xpath="//*[@id='User_lastName']")
	public WebElement LastName;
	@FindBy(xpath="//*[@id='User_username']")
	public WebElement UserName;
	@FindBy(xpath="//*[@id='User_password']")
	public WebElement pass;
	@FindBy(xpath="//select[@id='User_status']")
	public WebElement status;
	
}
