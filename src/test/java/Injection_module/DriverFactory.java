package Injection_module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;



public class DriverFactory {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public DriverFactory(){

    }

    public void createLocalDriver(String browserTypeLocal) {
        setDriverPath();
        switch (browserTypeLocal){
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                this.driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setAcceptInsecureCerts(true);
                this.driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                this.driver = new EdgeDriver(edgeOptions);
                break;
        }


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    private static void setDriverPath() {
        String pathToChromeDriver = "res/drivers/chromedriver.exe";
        String pathToFirefoxDriver = "res/drivers/geckodriver.exe";
        String pathToEdgeDriver = "res/drivers/msedgedriver.exe";

        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        System.setProperty("webdriver.gecko.driver", pathToFirefoxDriver);
        System.setProperty("webdriver.edge.driver", pathToEdgeDriver);
    }
}
