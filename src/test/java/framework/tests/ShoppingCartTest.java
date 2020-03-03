package framework.tests;

import framework.page.objects.*;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class ShoppingCartTest extends TestBase {

    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnEnterStoreLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnFish();

        FishListPage fishListPage = new FishListPage(driver);
        fishListPage.clickOnAngelFishProductId();

        AngelFishListPage angelFishListPage = new AngelFishListPage(driver);
        angelFishListPage.clickSmallAngelfishAddToCartButton();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickProceedToCheckoutButton();

        String expectedWarningMessage = "You must sign on before attempting to check out.";
        String actualText = loginPage.getWarningMessage();
        assertTrue(actualText.contains(expectedWarningMessage));
    }
}
