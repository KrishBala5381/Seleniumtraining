package org.pojo;

import org.basec.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class fbregpojo extends Baseclass {
	public fbregpojo() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[text()='Create new account']")
	private WebElement createNewAcc;
	
	@FindBy(name = "firstname")
	private WebElement firstNameTxtBox;
	
	@FindBy(name = "lastname")
	private WebElement secondNameTxtBox;
	
	@FindBy(name = "reg_email__")
	private WebElement mobileorEmailTxtBox;
	
	@FindBy(name = "reg_passwd__")
	private WebElement passwordTxtBox;

	public WebElement getCreateNewAcc() {
		return createNewAcc;
	}

	public WebElement getFirstNameTxtBox() {
		return firstNameTxtBox;
	}

	public WebElement getSecondNameTxtBox() {
		return secondNameTxtBox;
	}

	public WebElement getMobileorEmailTxtBox() {
		return mobileorEmailTxtBox;
	}

	public WebElement getPasswordTxtBox() {
		return passwordTxtBox;
	}

	public WebElement getLoginbtn() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
