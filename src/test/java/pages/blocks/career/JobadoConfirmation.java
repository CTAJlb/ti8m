package pages.blocks.career;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(css = "#jobabo-confirmation")
public class JobadoConfirmation extends HtmlElement {

    @FindBy(css = ".jobabo-subtitle")
    public WebElement jobaboSubtitle;
}
