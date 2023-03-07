package pages;

import helpers.BaseHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasicFormPage extends BaseHelpers {
    public interface Locators {
        By pageTitle = By.xpath("//h3[contains(text(), 'Basic Form Controls')]");
        By automationExperience = By.id("exp");
        By automationExperienceValidator = By.id("exp_help");
        By javaLanguageCheckbox = By.id("check_java");
        By pythonLanguageCheckbox = By.id("check_python");
        By javascriptLanguageCheckbox = By.id("check_javascript");
        By LanguageValidator = By.id("check_validate");
        By seleniumRadioButton = By.id("rad_selenium");
        By protractorRadioButton = By.id("rad_protractor");
        By radioButtonValidator = By.id("rad_validate");
        By primarySkillDropdown = By.id("select_tool");
        By skillValidator = By.id("select_tool_validate");
        By selectLanguage = By.id("select_lang");
        By languageValidator = By.id("select_lang_validate");
        By notes = By.id("notes");
        By notesValidator = By.id("area_notes_validate");
        By mandatorySkillReadOnly = By.id("common_sense");
        By speaksGerman = By.xpath("id(\"german\")/following-sibling::label");
        By germanValidator = By.id("german_validate");
        By germanFluency = By.id("fluency");
        By germanFluencyValidator = By.id("fluency_validate");
        By uploadCv = By.id("upload_cv");
        By validateCv = By.id("validate_cv");
        By uploadCertificates = By.id("upload_files");
        By validateCertificates = By.id("validate_files");
        By currentSalary = By.id("salary");
        By formWithValidationCity = By.id("validationCustom03");
        By formWithValidationState = By.id("validationCustom04");
        By formWithValidationZip = By.id("validationCustom05");
        By termsAndCondition = By.id("invalidCheck");
        By submitFormButton = By.xpath("//button[@class='btn btn-primary']");
    }

    public BasicFormPage() {
        openUrl(urlHelper.GITHUBIO_BASE_URL + urlHelper.BASIC_FORM_PAGE_URL);
        waitforElementVisible(Locators.pageTitle);
    }

    public void enterExperience(String experience) {
        setValue(Locators.automationExperience, experience);
    }

    public void selectJava() {
        clickElement(Locators.javaLanguageCheckbox);
    }

    public void selectPython() {
        clickElement(Locators.pythonLanguageCheckbox);
    }

    public void selectJavascript() {
        clickElement(Locators.javascriptLanguageCheckbox);
    }

    public void selectSelenium() {
        clickElement(Locators.seleniumRadioButton);
    }

    public void selectProtractor() {
        clickElement(Locators.protractorRadioButton);
    }

    public void selectPrimarySkill(String skill) {
        selectDropDownValue(Locators.primarySkillDropdown, skill);
    }

    public void selectLanguage(String text) {
        WebElement element = driver.findElement(Locators.selectLanguage);
        Select language = new Select(element);
        language.selectByVisibleText(text);
    }

    public void enterNotes(String notes) {
        setValue(Locators.notes, notes);
    }

    public void speakGerman(Boolean enable) {
        // Need to click toggle button once to generate `germanValidator` (green text of input).
        clickElement(Locators.speaksGerman);
        if (enable == true && elementContainsText(BasicFormPage.Locators.germanValidator, "false")) {
            clickElement(Locators.speaksGerman);
        } else if (enable == false && elementContainsText(BasicFormPage.Locators.germanValidator, "true")) {
            clickElement(Locators.speaksGerman);
        } else {
            System.out.println("Button is already enabled/diabled");
        }
    }

    public void setGermanFluency(int rating) {
        // Need to set slider to 0 for proper slide set later
        slideElement(Locators.germanFluency, "Left", 3);
        switch (rating) {
            case 0:
                System.out.println("Set to 0");
                break;
            case 1:
                slideElement(Locators.germanFluency, "Right", 1);
                break;
            case 2:
                slideElement(Locators.germanFluency, "Right", 2);
                break;
            case 3:
                slideElement(Locators.germanFluency, "Right", 3);
                break;
            case 4:
                slideElement(Locators.germanFluency, "Right", 4);
                break;
            case 5:
                slideElement(Locators.germanFluency, "Right", 5);
                break;
            default:
                System.out.println("Rating should be between 0 and 5");
                break;
        }
    }

    public void uploadCv(String cvPath) {
        uploadFile(BasicFormPage.Locators.uploadCv, System.getProperty("user.dir")+cvPath);
    }

    public void uploadCertificates(String certiPath) {
        uploadFile(BasicFormPage.Locators.uploadCertificates, System.getProperty("user.dir")+certiPath);
    }

    public void enterCity(String city) {
        setValue(Locators.formWithValidationCity, city);
    }

    public void enterState(String state) {
        setValue(Locators.formWithValidationState, state);
    }

    public void enterZip(String code) {
        setValue(Locators.formWithValidationZip, code);
    }

    public void agreeTermsAndContition() {
        clickElement(Locators.termsAndCondition);
    }

    public void clickSubmitFormButton() {
        clickElement(Locators.submitFormButton);
    }
}