package steps;

import Injection_module.ScenarioContext;
import com.google.inject.Inject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Log4j2
public class UiHooks {

    @Inject
    ScenarioContext scenarioContext;

    @Before(value = "@ui", order = 1)
    public void startUIBrowser() {
        scenarioContext.driverFactory.createLocalDriver(scenarioContext.props.browser);
    }

    @After(value = "@ui")
    public void closeBrowser() {
        Allure.attachment("Screenshot",
                new ByteArrayInputStream(makeScreenshot(scenarioContext.driverFactory.getDriver())));
        scenarioContext.driverFactory.getDriver().quit();
    }

    public byte[] makeScreenshot(WebDriver driver) {
        Screenshot screenshot = new AShot().takeScreenshot(driver);
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            ImageIO.write(screenshot.getImage(), "PNG", buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toByteArray();
    }

}

