package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertPage;
import setup.BrowserSetup;

public class verifyAlertBox extends BrowserSetup {
    @Test
    public void verifyAlertBoxIsPresent() {
        AlertPage ap = new AlertPage();

        ap.clickDisplayAlertBoxButton();
        Assert.assertTrue(ap.assertAlertBoxText("I am an alert box!"), "The alert message is not correct");
        ap.clickOkOnAlert();
    }
}
