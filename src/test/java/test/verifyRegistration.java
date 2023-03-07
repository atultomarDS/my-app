package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.BasicFormPage;
import page.RegistrationPage;
import setup.BrowserSetup;

public class verifyRegistration extends BrowserSetup{
	@Test
	public void successfulRegistration() {
		RegistrationPage rp = new RegistrationPage();

		rp.enterFirstName("Atul");
		rp.enterLastName("Tomar");
		rp.selectMaritalStatus("Married");
		rp.selectHobby("Cricket");
		rp.selectCountryFromDropdown("India");
		rp.selectDateOfBirth("1", "1", "2014");
		rp.enterPhoneNumber("12344556");
		rp.enterUsername("tommy123");
		rp.enterEmail("tomar.atul1@gmail.com");
		rp.uploadProfilePicture("/Users/atul.tomar/Downloads/image.jpeg");
		rp.enterAboutYourself("I am a QA");
		rp.enterPassword("qwerty");
		rp.enterConfirmPassword("qwerty");
		rp.clickSubmitButton();

		// There is no success page, so verifying that first name field is empty
		Assert.assertTrue(rp.verifyInputFieldIsEmpty(RegistrationPage.Locators.firstName));
	}
}
