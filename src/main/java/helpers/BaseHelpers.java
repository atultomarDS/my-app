package helpers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseHelpers {
    public static WebDriver driver;

    public WebDriver chromeLaunch() {

        System.setProperty("webdriver.chrome.driver", "/Users/atul.tomar/driver/chromedriver");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        return driver;
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void tearDown() {
        driver.quit();
    }

    public void waitforElementVisible(By by) {
        scrollToElement(by);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitforElementNotVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void clickElement(By by) {
        waitforElementVisible(by);
        driver.findElement(by).click();
    }

    public void selectDropDownValue(By by, String dropdownValue) {
        waitforElementVisible(by);
        Select dropdown = new Select(driver.findElement(by));

        dropdown.selectByVisibleText(dropdownValue);
    }

    public void setValue(By by, String value) {
        waitforElementVisible(by);
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(value);
    }

    public void uploadFile(By by, String filePath) {
        waitforElementVisible(by);
        driver.findElement(by).sendKeys(filePath);
    }

    public String getText(By by) {
        waitforElementVisible(by);
        String elementText = driver.findElement(by).getText();

        return elementText;
    }

    public Boolean verifyInputFieldIsEmpty(By by) {
        waitforElementVisible(by);
        String elementText = getAttribute(by, "value");

        if (elementText.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean elementContainsText(By by, String text) {
        waitforElementVisible(by);
        String actualString = getText(by);
        if (actualString.equalsIgnoreCase(text)) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean elementIsReadonly(By by) {
        return getAttribute(by, "readOnly").equals("true");
    }

    public Boolean elementIsDisabled(By by) {
        return getAttribute(by, "disabled").equals("true");
    }

    public void slideElement(By by, String dir, int times) {
        for (int i = 1; i <= times ; i++) {
            if (dir == "Right") {
                driver.findElement(by).sendKeys(Keys.ARROW_RIGHT);
            } else {
                driver.findElement(by).sendKeys(Keys.ARROW_LEFT);
            }
        }
    }

    public String getAttribute(By by, String attributeName) {
        String elementAttribute = driver.findElement(by).getAttribute(attributeName);

        return elementAttribute;
    }

    public List<WebElement> getAllElements(By by) {
        waitforElementVisible(by);
        List<WebElement> webElements = driver.findElements(by);

        return webElements;
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void switchToIframe(By by) {
        WebElement element = driver.findElement(by);

        driver.switchTo().frame(element);
    }

    public void scrollToElement(By by) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(by);
        je.executeScript("arguments[0].scrollIntoView(true);", element);
        implicitWait(5, TimeUnit.SECONDS);
    }

    public void implicitWait(int time, TimeUnit timeUnit) {
        driver.manage().timeouts().implicitlyWait(time, timeUnit);
    }
}
