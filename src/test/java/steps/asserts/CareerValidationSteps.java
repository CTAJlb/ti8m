package steps.asserts;

import Injection_module.ScenarioContext;
import com.google.inject.Inject;
import io.cucumber.java.en.Then;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.CareerPage;

@Log4j2
public class CareerValidationSteps {

    @Inject
    private CareerPage careerPage;

    @Inject
    ScenarioContext scenarioContext;

    @Then("[Career page] validate that relevant results is shown as {string} in job list title")
    public void validateThatJobTitleContains(String jobTitle) {
        careerPage.waitElementsVisible(careerPage.filterBlock.jobList, 10);
        Assert.assertTrue(careerPage.filterBlock.getJobTitles().stream()
                        .anyMatch(title -> title.contains(jobTitle)), "Job title "+jobTitle+ " not found in list");
    }

    @Then("[Career page] validate that no results message displayed")
    public void validateThatNoResultsMessageDisplayed() {
        Assert.assertEquals(careerPage.filterBlock.noResults.getText(), "Für deine Kriterien haben wir aktuell leider keine vakanten Stellen. Wir freuen uns, wenn du zu einem späteren Zeitpunkt wieder reinschaust oder direkt unser Job Abo abonnierst.");
    }

    @Then("[Career page] validate that success registration message displayed")
    public void validateThatSuccessRegistrationMessageDisplayed() {
        Assert.assertEquals(careerPage.jobadoConfirmation.jobaboSubtitle.getText(), "Besten Dank für deine Registrierung, du erhältst in Kürze eine Bestätigungsemail.");
    }

    @Then("[Career page] validate that jobs counter reduced")
    public void careerPageValidateThatJobsCounterReduced() {
        Assert.assertTrue(careerPage.filterBlock.getJobsSize() < scenarioContext.testData.getJobCounter(), "Jobs counter is not reduced");
    }

    @Then("[Career page] validate that jobs counter increased")
    public void careerPageValidateThatJobsCounterIncreased() {
        careerPage.waitFor(() -> careerPage.filterBlock.jobList.size() > scenarioContext.testData.getJobCounter(), 2);
        Assert.assertEquals(careerPage.filterBlock.getJobsSize(), scenarioContext.testData.getJobCounter(), "Jobs counter is not increased");
    }
}
