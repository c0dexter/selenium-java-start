package framework.tests;

import framework.page.objects.FooterPage;
import framework.page.objects.LandingPage;
import framework.page.objects.LoginPage;
import framework.page.objects.TopMenuPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class PositiveLoginTests extends TestBase {

    @Test
    public void asUserTryToLogInWithCorrectLoginAndPassword() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnEnterStoreLink();

        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickOnSignOnLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUserNameField("j2ee");
        loginPage.typeIntoPasswordField("j2ee");
        loginPage.clickOnLoginButton();

        FooterPage footerPage = new FooterPage(driver);
        assertTrue(footerPage.isBannerAfterLoginDisplayed());
    }
}
