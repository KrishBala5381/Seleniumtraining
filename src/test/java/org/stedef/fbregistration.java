package org.stedef;

import org.basec.Baseclass;
import org.pojo.fbregpojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class fbregistration extends Baseclass {
	fbregpojo s;

	@Given("To launch the browser and maximise the window")
	public void to_launch_the_browser_and_maximise_the_window() {
		launchBrowser();
		windowmaximize();
	}

	@When("To launch the url of fb application")
	public void to_launch_the_url_of_fb_application() {
		launchurl("https://en-gb.facebook.com/");

	}

	@When("To click the create new account button")
	public void to_click_the_create_new_account_button() throws InterruptedException {
		s = new fbregpojo();
		clickBtn(s.getCreateNewAcc());
		Thread.sleep(5000);
	}

	@When("To pass the firstname in firstname text box")
	public void to_pass_the_firstname_in_firstname_text_box() throws InterruptedException {
		Thread.sleep(5000);
		s = new fbregpojo();
		passtext("bala", s.getFirstNameTxtBox());
	}

	@When("To pass the second name in secondname test box")
	public void to_pass_the_second_name_in_secondname_test_box() {
		s = new fbregpojo();
		passtext("krishnan", s.getSecondNameTxtBox());
	}

	@When("To pass mobile number or email in mail text box")
	public void to_pass_mobile_number_or_email_in_mail_text_box() {
		s = new fbregpojo();
		passtext("balakrishnan@gmail.com", s.getMobileorEmailTxtBox());
	}

	@When("To create new password in new password text box")
	public void to_create_new_password_in_new_password_text_box() {
		s = new fbregpojo();
		passtext("123456789", s.getPasswordTxtBox());
	}

	@Then("To close the chrome browser")
	public void to_close_the_chrome_browser() {
		// closeEntireBrowser();
	}

}
