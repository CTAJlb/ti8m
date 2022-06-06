package steps;

import Injection_module.ScenarioContext;
import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import pages.CareerPage;

import java.util.List;
import java.util.Map;

@Log4j2
public class CareerPageSteps {

        @Inject
        CareerPage careerPage;

        @Inject
        ScenarioContext scenarioContext;

        @Then("[Career page] submit checkboxes and search input field with next params")
        public void submitFilterWithNextParams(List<Map<String, String>> params) {
                careerPage.switchToFrame();
                for (Map<String, String> param : params) {
                        if(param.get("Location") != null) {
                                careerPage.filterBlock.setLocationCheckBox(param.get("Location"));
                        }
                        if(param.get("ProfessionalField") != null) {
                                careerPage.filterBlock.setProfessionalFieldCheckBox(param.get("ProfessionalField"));
                        }
                        if(param.get("Seniority") != null) {
                                careerPage.filterBlock.setSeniorityCheckBox(param.get("Seniority"));
                        }
                        if(param.get("SearchInput") != null) {
                                careerPage.filterBlock.setSearchInput(param.get("SearchInput"));
                        }
                }
        }

        @Then("[Career page] set {string} text in the search field")
        public void setSearchField(String inputValue) {
                careerPage.switchToFrame();
                careerPage.filterBlock.setSearchInput(inputValue);
        }

        @Given("[Career page] open")
        public void openCareerPage() {
                careerPage.open();
                careerPage.submitCookies();
        }


        @When("[Career page] click subscribe new jobs button")
        public void clickSubscriptionButton() {
                careerPage.switchToFrame();
                careerPage.filterBlock.clickSubscribeJobButton();
        }

        @When("[Career page] set subscription form with next params")
        public void setSubscriptionFormWithNextParams(List<Map<String, String>> params) {
                careerPage.switchToNewWindow();

                for (Map<String, String> param : params) {
                        careerPage.jobadoInputForm.setSearchInput(param.get("Profession"));
                        careerPage.jobadoInputForm.setLocationCheckBox(param.get("Location"));
                        careerPage.jobadoInputForm.setProfessionalFieldCheckBox(param.get("ProfessionalField"));
                        careerPage.jobadoInputForm.setSeniorityCheckBox(param.get("Seniority"));
                }
                careerPage.jobadoInputForm.acceptSingleOptCheckbox();
                careerPage.jobadoInputForm.clickSubscribeButtonToProceedStep2();
                for (Map<String, String> param : params) {
                        careerPage.jobadoInputForm.setDesignationField(param.get("Designation"));
                        careerPage.jobadoInputForm.setEmailField(param.get("Email"));
                }
                careerPage.jobadoInputForm.clickCompleteRegistrationButton();
        }

        @When("[Career page] set professional field check box with data {string}")
        public void setProfessionalFieldCheckBox(String value) {
                careerPage.filterBlock.setProfessionalFieldCheckBox(value);
                careerPage.waitElementsVisible(careerPage.filterBlock.jobList, 10);
        }

        @When("[Career page] remove professional field check box with data {string}")
        public void removeProfessionalFieldCheckBox(String value) {
                careerPage.filterBlock.removeProfessionalFieldCheckBox(value);
        }

        @When("[Career page] remember jobs counter")
        public void rememberJobCounter() {
              scenarioContext.testData.setJobCounter(careerPage.filterBlock.getJobsSize());
        }
}
