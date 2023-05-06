package org.pojo;

import org.base.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class projectpojo extends Baseclass {
	// non parameterized constructor
	public projectpojo() {
		PageFactory.initElements(driver, this);

	}

	// private webelements
	// webelement email = driver.findelement(By.id("email");
	@FindBy(xpath = "//input[@type='text']")
	private WebElement email;
	@FindBy(xpath = "//input[@aria-label='Password']")
	private WebElement password;
	@FindBy(name = "login")
	private WebElement loginbtn;

	// getters to access webelements outside the class
	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

}
