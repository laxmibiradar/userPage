package com.crm.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.crm.objectRepository.UsersObjectRepo;

public class UsersPage extends UsersObjectRepo{
	WebDriver driver;
	public UsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String navigatetoUserLink() {
		userLink.click();
		String exp="CRM Tech - Admin Users";
		return exp;
	}
	public boolean checkSideMenu() {
		ArrayList<String>actualMenu=new ArrayList<String>();
		List<WebElement>allnavigation=menu;
		for (WebElement subtitle : allnavigation) {
			String Text=subtitle.getText();
			actualMenu.add(Text);	
		}
		ArrayList<String>expectedmenu=new ArrayList<String>();
		expectedmenu.add("Actions");
		expectedmenu.add("Favorites");
		expectedmenu.add("Recent Items");
		if (actualMenu.equals(expectedmenu)) {
			return true;
		}else 
			return false;

	}
	public boolean verifyLogo() {
		Boolean image=logo.isDisplayed();
		return image;

	}
	public int headerOnUserPage() {
		int count= header.size();
		return count;

	}
	public int activeUser() {
		int activeusers=activeUser.size();
		return activeusers;
	}
	public String newUserAdded() {

		return null;

	}
}
