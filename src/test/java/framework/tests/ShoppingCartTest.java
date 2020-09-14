package framework.tests;

import framework.page.objects.LandingPage;
import framework.page.objects.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class ShoppingCartTest extends TestBase {

    @TmsLink("ID-3")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("The goal of this test is to check that the user cannot to attempt checkout before being signed in")
    public void asNotLoggedInUserIShallNotProceedToCheckout() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink();

        LoginPage loginPage = new LoginPage();
        loginPage
                .clickOnFish()
                .clickOnAngelFishProductId()
                .clickSmallAngelfishAddToCartButton()
                .clickProceedToCheckoutButton();

        String warningMessage = loginPage.getWarningMessage();

        String expectedWarningMessage = "You must sign on before attempting to check out.";
        assertTrue(warningMessage.contains(expectedWarningMessage));
    }
}
