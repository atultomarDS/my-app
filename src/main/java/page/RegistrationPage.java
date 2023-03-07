package page;

import java.util.List;

import helpers.BaseHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BaseHelpers {
    public interface Locators {
        By firstName = By.name("name");
        By lastName = By.xpath("//*[contains(text(), \"Last Name\")]/following-sibling::input");
        By maritalStatusRadioButton = By.xpath("//div[@class='radio_wrap']/label/input[@name='m_status']");
        By hobbyCheckbox = By.name("hobby");
        By countryDropdown = By.xpath("//*[contains(text(), \"Country\")]/following-sibling::select");
        By monthDOBDropdown = By.xpath("//div[@class='time_feild'][1]/select");
        By dayDOBDropdown = By.xpath("//div[@class='time_feild'][2]/select");
        By yearDOBDropdown = By.xpath("//div[@class='time_feild'][3]/select");
        By phoneNumberInputField = By.name("phone");
        By usernameInputField = By.name("username");
        By emailInputField = By.name("email");
        By yourProfilePictureButton = By.xpath("//*[contains(text(), \"Your Profile Picture\")]/following-sibling::input");
        By aboutYourselfInputField = By.xpath("//*[contains(text(), \"About Yourself\")]/following-sibling::textarea");
        By passwordInputField = By.name("password");
        By confirmPasswordInputField = By.name("c_password");
        By submitButton = By.xpath("//*[@id=\"register_form\"]/fieldset[13]/input");
    }

    public RegistrationPage() {
        openUrl("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
        waitforElementVisible(Locators.submitButton);
    }

    public void enterFirstName(String firstName) {
        setValue(Locators.firstName, firstName);
    }

    public void enterLastName(String lastName) {
        setValue(Locators.lastName, lastName);
    }

    public void selectCountryFromDropdown(String countryName) {
        selectDropDownValue(Locators.countryDropdown, countryName);
    }

    public void selectDateOfBirth(String month, String day, String year) {
        selectDropDownValue(Locators.monthDOBDropdown, month);
        selectDropDownValue(Locators.dayDOBDropdown, day);
        selectDropDownValue(Locators.yearDOBDropdown, year);
    }

    public void enterPhoneNumber(String phoneNumber) {
        setValue(Locators.phoneNumberInputField, phoneNumber);
    }

    public void enterUsername(String username) {
        setValue(Locators.usernameInputField, username);
    }

    public void enterEmail(String email) {
        setValue(Locators.emailInputField, email);
    }

    public void uploadProfilePicture(String picturePath) {
        uploadFile(Locators.yourProfilePictureButton, picturePath);
    }

    public void enterAboutYourself(String aboutYourself) {
        setValue(Locators.aboutYourselfInputField, aboutYourself);
    }

    public void enterPassword(String password) {
        setValue(Locators.passwordInputField, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        setValue(Locators.confirmPasswordInputField, confirmPassword);
    }

    public void selectMaritialStatus(String status) {
        List<WebElement> maritialStatusElements = getAllElements(Locators.maritalStatusRadioButton);

        for (WebElement maritialEle : maritialStatusElements) {
            maritialEle.click();
            break;
        }
    }

    public void selectHobby(String hobby) {
        List<WebElement> hobbyElements = getAllElements(Locators.hobbyCheckbox);

        for (WebElement hobbyEle : hobbyElements) {
            hobbyEle.click();
            break;
        }
    }

    public void clickSubmitButton() {
        clickElement(Locators.submitButton);
    }
}