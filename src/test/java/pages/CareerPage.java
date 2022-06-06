package pages;

import Injection_module.ScenarioContext;
import com.google.inject.Inject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.blocks.CookieBanner;
import pages.blocks.career.FilterBlock;
import pages.blocks.career.JobadoConfirmation;
import pages.blocks.career.JobadoInputForm;


public class CareerPage extends BasePage {

    CookieBanner cookieBanner;
    public FilterBlock filterBlock;
    public JobadoInputForm jobadoInputForm;
    public JobadoConfirmation jobadoConfirmation;


    @FindBy(css = ".ti8m-iframe")
    private WebElement ti8mIframe;

    @Inject
    ScenarioContext scenarioContext;

    @Inject
    public CareerPage(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }

    @Override
    public void open() {
        scenarioContext.driverFactory.getDriver().get(scenarioContext.props.baseUrl + "/career");
    }



    public void submitCookies() {
        if(isElementPresent(cookieBanner.complianceButton)) {
            cookieBanner.complianceButton.click();
        }
    }

    public void switchToFrame() {
        scrollIntoViewJS(ti8mIframe);
        switchToFrame(ti8mIframe);
    }





}
