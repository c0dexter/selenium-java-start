package framework.tests;

import framework.page.objects.*;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class ShoppingCartTest extends TestBase {

    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink();

        LoginPage loginPage = new LoginPage();
        loginPage.clickOnFish();

        FishListPage fishListPage = new FishListPage();
        fishListPage.clickOnAngelFishProductId();

        AngelFishListPage angelFishListPage = new AngelFishListPage();
        angelFishListPage.clickSmallAngelfishAddToCartButton();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.clickProceedToCheckoutButton();

        String expectedWarningMessage = "You must sign on before attempting to check out.";
        String actualText = loginPage.getWarningMessage();
        assertTrue(actualText.contains(expectedWarningMessage));
    }
}
