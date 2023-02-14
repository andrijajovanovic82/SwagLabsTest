package SwagLabs.SwagLabsTests;

import SwagLabs.SwagLabsBase.SwagLabsBaseTest;
import SwagLabs.SwagLabsPages.SwagLabsHomePage;
import SwagLabs.SwagLabsPages.SwagLabsInventoryPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwagLabsLogoutTest extends SwagLabsBaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(loginURL);
        homePage = new SwagLabsHomePage();
        inventoryPage = new SwagLabsInventoryPage();
    }

    @Test
    public void userCanLogOut() throws InterruptedException {
        logIn();
        inventoryPage.clickBurgermenu();
        Thread.sleep(1000);
        inventoryPage.clickLogoutButton();
        Assert.assertTrue(homePage.getLoginButton().isDisplayed());
        Assert.assertTrue(homePage.getUsername().isDisplayed());
        Assert.assertTrue(homePage.getPassword().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }
}
