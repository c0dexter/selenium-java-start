package framework.tests;

import framework.driver.manager.DriverUtils;
import framework.page.objects.LoginPage;
import framework.utils.testng.listeners.RetryAnalyzer;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static framework.navigation.ApplicationURLs.LOGIN_URL;

public class FailedLoginTests extends TestBase {

    @Issue("DEFECT-1")
    @TmsLink("ID-1")
    @Severity(SeverityLevel.NORMAL)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The goal of this test is to log in using not proper username and password" +
            " and check if warning message Invalid username or password is displayed")
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUserNameField("NotExistingLogin");
        loginPage.typeIntoPasswordField("NotProperPassword");
        loginPage.clickOnLoginButton();

        loginPage.assertThatWarningIsDisplayed("Invalid username or password. Signon failed. 222222");
    }
}
