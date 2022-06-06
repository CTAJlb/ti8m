package pages.blocks.career;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@FindBy(css = "#wrapper")
public class FilterBlock extends HtmlElement {

    @FindBy(xpath = "//*[@name='query']")
    public WebElement searchInput;

    @FindBy(xpath = "//*[@name='filter_10']")
    public List<CheckBox> locationCheckBox;

    @FindBy(xpath = "//*[@name='filter_20']")
    public List<CheckBox> professionalFieldCheckBox;

    @FindBy(xpath = "//*[@name='filter_30']")
    public List<CheckBox> seniorityCheckBox;

    @FindBy(css = ".job")
    public List<WebElement> jobList;

    @FindBy(css = "#jobabo-subscribe-button")
    public WebElement subscribeJobButton;

    @FindBy(css = "#no-results")
    public WebElement noResults;

    public void setSearchInput(String value) {
        searchInput.clear();
        searchInput.sendKeys(value);
    }

    public void setLocationCheckBox(String location) {
        locationCheckBox.stream()
                .filter(checkbox -> checkbox.findElement(By.xpath("following-sibling::label")).getText().equals(location))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can not find check box with location " + location))
                .click();
    }


    public void setProfessionalFieldCheckBox(String profField) {
        professionalFieldCheckBox.stream()
                .filter(checkbox -> checkbox.findElement(By.xpath("following-sibling::label")).getText().equals(profField))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can not find check box with professional field " + profField))
                .click();
    }

    public void removeProfessionalFieldCheckBox(String profField) {
        professionalFieldCheckBox.stream()
                .filter(checkbox -> checkbox.findElement(By.xpath("following-sibling::label")).getText().equals(profField))
                .filter(TypifiedElement::isSelected)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can not find check box with professional field " + profField))
                .click();

    }

    public void setSeniorityCheckBox(String seniority) {
        seniorityCheckBox.stream()
                .filter(checkbox -> checkbox.findElement(By.xpath("following-sibling::label")).getText().equals(seniority))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can not find check box with seniority " + seniority))
                .click();
    }

    public List<String> getJobTitles() {
        List<String> jobTitleList = new ArrayList<>();
        jobList.forEach(job ->
                jobTitleList.add(job.findElement(By.cssSelector(".title")).getText()));
        return jobTitleList;
    }

    public void clickSubscribeJobButton() {
        subscribeJobButton.click();
    }

    public int getJobsSize() {
        return jobList.size();
    }


}
