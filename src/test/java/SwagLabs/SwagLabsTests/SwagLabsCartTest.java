package SwagLabs.SwagLabsTests;

import SwagLabs.SwagLabsBase.SwagLabsBaseTest;
import SwagLabs.SwagLabsPages.SwagLabsCartPage;
import SwagLabs.SwagLabsPages.SwagLabsHomePage;
import SwagLabs.SwagLabsPages.SwagLabsInventoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwagLabsCartTest extends SwagLabsBaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        homePage = new SwagLabsHomePage();
        inventoryPage = new SwagLabsInventoryPage();
        cartPage = new SwagLabsCartPage();
    }

    @Test
    public void addOneProductToCart() throws InterruptedException {
        logIn();
        inventoryPage.clickOnAddToCartFleeceJacket();
        inventoryPage.clickOnShoppingCart();
        Thread.sleep(1000);
//        cartPage.clickOnRemoveButton();
//        cartPage.clickOnContinueShoppingButton();
    }

    @Test
    public void addTwoProductsToCart() throws InterruptedException {
        logIn();
        inventoryPage.clickOnAddToCartFleeceJacket();
        inventoryPage.clickOnShoppingCart();
        Thread.sleep(1000);
        cartPage.clickOnContinueShoppingButton();
        inventoryPage.clickOnAddToCartBackpack();
        inventoryPage.clickOnShoppingCart();
//        Thread.sleep(1000);
//        cartPage.clickOnRemoveButton();
//        cartPage.clickOnRemoveButton();
//        cartPage.clickOnContinueShoppingButton();

    }

    @Test
    public void addThreeProductsToCart() throws InterruptedException {
        logIn();
        inventoryPage.clickOnAddToCartFleeceJacket();
        inventoryPage.clickOnShoppingCart();
//        WebElement cartQuantity = driver.findElement(By.cssSelector("div[cart_quantity='1']"));
        Thread.sleep(1000);
        cartPage.clickOnContinueShoppingButton();
        inventoryPage.clickOnAddToCartBackpack();
        inventoryPage.clickOnShoppingCart();
        Thread.sleep(1000);
        cartPage.clickOnContinueShoppingButton();
        inventoryPage.clickOnAddToCartBoltTShirt();
        inventoryPage.clickOnShoppingCart();
//        Thread.sleep(1000);
//        cartPage.clickOnRemoveButton();
//        cartPage.clickOnRemoveButton();
//        cartPage.clickOnRemoveButton();
//        cartPage.clickOnContinueShoppingButton();
    }


}
