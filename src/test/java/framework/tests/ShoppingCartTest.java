package framework.tests;

import framework.page.objects.LandingPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class ShoppingCartTest extends TestBase {

    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout() {
        LandingPage landingPage = new LandingPage();
        String actualText = landingPage
                .clickOnEnterStoreLink()
                .clickOnFish()
                .clickOnAngelFishProductId()
                .clickSmallAngelfishAddToCartButton()
                .clickProceedToCheckoutButton()
                .getWarningMessage();

        String expectedWarningMessage = "You must sign on before attempting to check out.";
        assertTrue(actualText.contains(expectedWarningMessage));
    }
}
