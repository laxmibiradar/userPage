package com.crm.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class UsersPageTest extends BaseClass {
	@Test
	public void moveToUserPage() {
		Assert.assertEquals(driver.getTitle(), up.navigatetoUserLink());
	}
	@Test
	public void sideMenu() {
	Assert.assertTrue(up.checkSideMenu());	
	}
	@Test
	public void logoDisplay() {
		Assert.assertTrue(up.verifyLogo());
	}
	@Test
	public void headerInTable() {
	Assert.assertEquals(7, up.headerOnUserPage());	
	}
	@Test
	public void activePerson() {
		Assert.assertEquals(4, up.activeUser());
	}
}
