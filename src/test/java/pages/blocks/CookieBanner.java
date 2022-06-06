package pages.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(css = ".cc-window.cc-banner")
public class CookieBanner extends HtmlElement {

    @FindBy(css = ".cc-compliance")
    public WebElement complianceButton;

}
