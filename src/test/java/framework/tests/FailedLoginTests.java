package framework.tests;

import framework.page.objects.LandingPage;
import framework.page.objects.LoginPage;
import framework.page.objects.TopMenuPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTests extends TestBase {

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnEnterStoreLink();

        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickOnSignOnLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUserNameField("NotExistingLogin");
        loginPage.typeIntoPasswordField("NotProperPassword");
        loginPage.clickOnLoginButton();

        assertEquals(loginPage.getWarningMessage(), "Invalid username or password. Signon failed.");
    }
}
