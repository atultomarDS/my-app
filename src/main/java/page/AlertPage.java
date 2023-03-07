package page;

import helpers.BaseHelpers;
import helpers.UrlHelper;
import org.openqa.selenium.By;

public class AlertPage extends BaseHelpers {

    public interface Locators {
        By iframe_element = By.xpath("//iframe[@class='demo-frame']");
        By displayAlertBoxButton = By.xpath("//button[contains(text(),'Click the button to display an alert box:')]");
    }

    public AlertPage() {
        openUrl(urlHelper.WAY2AUTOMATION_BASE_URL + urlHelper.ALERT_PAGE_URL);
        switchToIframe(Locators.iframe_element);
        waitforElementVisible(Locators.displayAlertBoxButton);
    }

    public Boolean assertAlertBoxText(String alertText) {
        String text = getAlertText();
        if (alertText.equalsIgnoreCase(text)) {
            System.out.println("Alert message is present: " + text);
            return true;
        } else {
            return false;
        }
    }

    public void clickDisplayAlertBoxButton() {
        clickElement(Locators.displayAlertBoxButton);
    }

    public void clickOkOnAlert() {
        acceptAlert();
    }
}