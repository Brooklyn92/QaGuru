package lesson5.hw5;

import lesson5.hw5.steps.WebSteps;
import org.junit.jupiter.api.Test;

public class GitHubLambdaStep extends TestBase {
    private static final String repository = "selenide/selenide";
    private static  final String issueName="Get web console logs from firefox";
    private static final Integer issueNumber=1636;

    WebSteps steps =new WebSteps();

    @Test
    public void testGitGubWithLambdaStep(){
        steps.openPageGitHub();
        steps.searchRepository(repository);
        steps.goToRepository(repository);
        steps.checkTabIssue();
        steps.goTabIssue();
        steps.checkInTabIssueNameRepositoryAndNumber(issueName,issueNumber);
        steps.takeScreenshot();

    }
}
