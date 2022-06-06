package pages;

import Injection_module.ScenarioContext;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.Callable;

public abstract class BasePage {

    protected ScenarioContext scenarioContext;
    protected WebDriver driver;

    public BasePage(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        this.driver = scenarioContext.driverFactory.getDriver();
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public abstract void open();

    public boolean isElementPresent(WebElement element) {
        boolean res = false;
        try {
            element.isDisplayed();
            res = true;
        } catch (Exception ignored) {
        }
        return res;
    }

    public void waitElementVisible(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementsVisible(List<WebElement> element, int secTime) {
        try {
             new FluentWait<>(driver).
                    withTimeout(Duration.ofSeconds(secTime)).
                    pollingEvery(Duration.ofMillis(100)).
                    ignoring(StaleElementReferenceException.class).
                    until(ExpectedConditions.visibilityOfAllElements(element));
        } catch (TimeoutException ignored) {}
    }

    public synchronized boolean waitFor(Callable calledMethod, int waitTimeSeconds) {
        int timer = 0;
        int steps = 0;
        try {
            while (waitTimeSeconds * 10 > timer) {
                wait(100);
                boolean result = (boolean) calledMethod.call();
                if (result) {
                    if (steps == 3) {
                        notify();
                        return true;
                    }
                    steps++;
                }
                timer++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        notify();
        return false;
    }

    public static boolean isElementPresent(List<WebElement> element) {
        try {
            return element.size() > 0;
        } catch (Exception ignored) {
        }
        return false;
    }

    public void scrollIntoViewJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void switchToNewWindow() {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }



}
