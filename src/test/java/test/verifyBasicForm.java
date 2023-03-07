package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.BasicFormPage;
import setup.BrowserSetup;

public class verifyBasicForm extends BrowserSetup {
    @Test
    public void verifyAlertBoxIsPresent() {
        BasicFormPage bf = new BasicFormPage();

        bf.enterExperience("10");
        Assert.assertTrue(bf.elementContainsText(BasicFormPage.Locators.automationExperienceValidator, "10"));

        bf.selectJava();
        Assert.assertTrue(bf.elementContainsText(BasicFormPage.Locators.LanguageValidator, "JAVA"));

        bf.selectSelenium();
        Assert.assertTrue(bf.elementContainsText(BasicFormPage.Locators.radioButtonValidator, "SELENIUM"));

        bf.selectPrimarySkill("Cypress");
        Assert.assertTrue(bf.elementContainsText(BasicFormPage.Locators.skillValidator, "cyp"));

        bf.selectLanguage("Python");
        Assert.assertTrue(bf.elementContainsText(BasicFormPage.Locators.languageValidator, "python"));

        bf.enterNotes("Noted");
        Assert.assertTrue(bf.elementContainsText(BasicFormPage.Locators.notesValidator, "Noted"));

        Assert.assertTrue(bf.elementIsReadonly(BasicFormPage.Locators.mandatorySkillReadOnly));

        bf.speakGerman(false);
        Assert.assertTrue(bf.elementContainsText(BasicFormPage.Locators.germanValidator, "false"));

        bf.setGermanFluency(2);
        Assert.assertTrue(bf.elementContainsText(BasicFormPage.Locators.germanFluencyValidator, "2"));

        bf.uploadCv("/Users/atul.tomar/Downloads/image.jpeg");
        Assert.assertTrue(bf.elementContainsText(BasicFormPage.Locators.validateCv, "image.jpeg"));

        bf.uploadCertificates("/Users/atul.tomar/Downloads/image.jpeg");
        Assert.assertTrue(bf.elementContainsText(BasicFormPage.Locators.validateCertificates, "image.jpeg"));

        Assert.assertTrue(bf.elementIsDisabled(BasicFormPage.Locators.currentSalary));

        bf.enterCity("Hamburg");
        bf.enterState("Germany");
        bf.enterZip("22087");
        bf.agreeTermsAndContition();
        bf.clickSubmitFormButton();

        // There is no success page, so verifying that automation experience field is empty
        Assert.assertTrue(bf.verifyInputFieldIsEmpty(BasicFormPage.Locators.automationExperience));
    }
}
