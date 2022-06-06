package pages.blocks.career;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

@FindBy(css = "#jobabo-form")
public class JobadoInputForm extends HtmlElement {

    @FindBy(css = "input[name=query]")
    public WebElement inputQueryField;

    @FindBy(xpath = "(//*[@class='filter'])[1]")
    public WebElement locationFilter;

    @FindBy(xpath = "(//*[@class='filter'])[2]")
    public WebElement professionalFilter;

    @FindBy(xpath = "(//*[@class='filter'])[3]")
    public WebElement seniorityFilter;

    @FindBy(xpath = "//*[@name='filter_10']")
    public List<WebElement> locationCheckBox;

    @FindBy(xpath = "//*[@name='filter_20']")
    public List<WebElement> professionalFieldCheckBox;

    @FindBy(xpath = "//*[@name='filter_30']")
    public List<WebElement> seniorityCheckBox;

    @FindBy(css = "#single-opt-in")
    public CheckBox singleOptCheckBox;

    @FindBy(xpath = "//*[@class='button jobabo-subscribe-button'][@type='button']")
    public WebElement subscribeButtonToStep2;

    @FindBy(xpath = "//*[@name='jobabo_bezeichnung']")
    public WebElement designationField;

    @FindBy(xpath = "//*[@name='jobabo_email']")
    public WebElement emailField;

    @FindBy(xpath = "//*[@class='button jobabo-subscribe-button'][@type='submit']")
    public WebElement completeRegistrationButton;

    public void setSearchInput(String value) {
        inputQueryField.clear();
        inputQueryField.sendKeys(value);
    }

    public void setLocationCheckBox(String location) {
        locationFilter.click();
        locationCheckBox.stream()
                .filter(checkbox -> checkbox.findElement(By.xpath("following-sibling::label")).getText().equals(location))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can not find check box with location " + location))
                .click();
    }

    public void setProfessionalFieldCheckBox(String profField) {
        professionalFilter.click();
        professionalFieldCheckBox.stream()
                .filter(checkbox -> checkbox.findElement(By.xpath("following-sibling::label")).getText().equals(profField))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can not find check box with professional field " + profField))
                .click();
    }

    public void setSeniorityCheckBox(String seniority) {
        seniorityFilter.click();
        seniorityCheckBox.stream()
                .filter(checkbox -> checkbox.findElement(By.xpath("following-sibling::label")).getText().equals(seniority))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can not find check box with seniority " + seniority))
                .click();
    }

    public void acceptSingleOptCheckbox() {
        if(!singleOptCheckBox.isSelected()) {
            singleOptCheckBox.select();
        }
    }

    public void clickSubscribeButtonToProceedStep2() {
        subscribeButtonToStep2.click();
    }

    public void setDesignationField(String value) {
        designationField.clear();
        designationField.sendKeys(value);
    }

    public void setEmailField(String value) {
        emailField.clear();
        emailField.sendKeys(value);
    }

    public void clickCompleteRegistrationButton() {
        completeRegistrationButton.click();
    }

}
