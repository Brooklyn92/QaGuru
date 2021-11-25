package lesson5;
import lesson5.steps.WebSteps;
import org.junit.jupiter.api.Test;

public class StepAnnotatedTest extends TestBase {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUE_NUMBER = 68;
    private WebSteps steps=new WebSteps();
    @Test
    public void testGitHub(){
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
        steps.takeScreenshot();
    }
}
 