package framework.tests;

import framework.driver.manager.DriverUtils;
import framework.page.objects.LandingPage;
import org.testng.annotations.Test;

import static framework.navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.AssertJUnit.assertTrue;

public class PositiveLoginTests extends TestBase {

    @Test
    public void asUserTryToLogInWithCorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LandingPage landingPage = new LandingPage();

        boolean isBannerAfterLoginDisplayed = landingPage
                .clickOnEnterStoreLink()
                .clickOnSignOnLink()
                .typeIntoUserNameField("j2ee")
                .typeIntoPasswordField("j2ee")
                .clickOnLoginButton()
                .isBannerAfterLoginDisplayed();

        assertTrue(isBannerAfterLoginDisplayed);
    }
}
