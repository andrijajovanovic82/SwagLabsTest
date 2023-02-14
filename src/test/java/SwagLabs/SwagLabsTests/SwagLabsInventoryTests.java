package SwagLabs.SwagLabsTests;

import SwagLabs.SwagLabsBase.SwagLabsBaseTest;
import SwagLabs.SwagLabsPages.SwagLabsHomePage;
import SwagLabs.SwagLabsPages.SwagLabsInventoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SwagLabsInventoryTests extends SwagLabsBaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        homePage = new SwagLabsHomePage();
        inventoryPage = new SwagLabsInventoryPage();
    }
    @Test
    public void sortProducts() throws InterruptedException {
        logIn();
        Thread.sleep(2000);
        inventoryPage.clickSortButton();
        inventoryPage.clickSortZToAButton();
        inventoryPage.inventoryAssertOrderByName("Test.allTheThings() T-Shirt (Red)");
//        inventoryPage.inventoryPrint();
//        System.out.println("-------------------");
        inventoryPage.clickSortButton();
        inventoryPage.clickSortAToZButton();
        inventoryPage.inventoryAssertOrderByName("Sauce Labs Backpack");
//        inventoryPage.inventoryPrint();
//        System.out.println("-------------------");
        inventoryPage.clickSortButton();
        inventoryPage.clickSortLowToHighButton();
        inventoryPage.inventoryAssertOrderByName("Sauce Labs Onesie");
//        inventoryPage.inventoryPrint();
//        System.out.println("-------------------");
        inventoryPage.clickSortButton();
        inventoryPage.clickSortHighToLowButton();
        inventoryPage.inventoryAssertOrderByName("Sauce Labs Fleece Jacket");
//        inventoryPage.inventoryPrint();
//        System.out.println("-------------------");
    }

    @Test
    public void sideBarMenu() throws InterruptedException {
        logIn();
        inventoryPage.burgerMenu.click();
        Thread.sleep(1000);
        inventoryPage.clickAboutButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");
        driver.navigate().back();
        inventoryPage.clickResetAPPStateButton();
        inventoryPage.clickLogoutButton();
        Assert.assertTrue(homePage.getLoginButton().isDisplayed());
    }
    @Test
    public void socialMediaButtons() throws InterruptedException {

        logIn();

        scrollToElement(inventoryPage.twitter);
        inventoryPage.clickOnTwitterButton();
        Thread.sleep(1000);
        inventoryPage.assertSocialMedia("https://twitter.com/saucelabs");

        scrollToElement(inventoryPage.facebook);
        inventoryPage.clickOnFacebookButton();
        Thread.sleep(1000);
        inventoryPage.assertSocialMedia("https://www.facebook.com/saucelabs");

        scrollToElement(inventoryPage.linkedIn);
        inventoryPage.clickOnLinkedInButton();
        Thread.sleep(1000);
        inventoryPage.assertSocialMedia("https://www.linkedin.com/company/sauce-labs/");

    }
}


