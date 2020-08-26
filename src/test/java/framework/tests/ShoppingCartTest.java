package framework.tests;

import framework.page.objects.LandingPage;
import framework.page.objects.LoginPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class ShoppingCartTest extends TestBase {

    @Test
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
