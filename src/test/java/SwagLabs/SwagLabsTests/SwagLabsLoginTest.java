package SwagLabs.SwagLabsTests;

import SwagLabs.SwagLabsBase.ExcelReader;
import SwagLabs.SwagLabsBase.SwagLabsBaseTest;
import SwagLabs.SwagLabsPages.SwagLabsHomePage;
import SwagLabs.SwagLabsPages.SwagLabsInventoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwagLabsLoginTest extends SwagLabsBaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(loginURL);
        homePage = new SwagLabsHomePage();
        inventoryPage = new SwagLabsInventoryPage();
    }

    @Test(priority = 10)
    public void userCanLogIn() throws InterruptedException {
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String validUsername = excelReader.getStringData("Login", i, 0);
            String validPassword = excelReader.getStringData("Login", 1, 1);
            homePage.insertUsername(validUsername);
            homePage.insertPassword(validPassword);
            homePage.clickOnLoginButton();
            Thread.sleep(2000);

            Assert.assertTrue(inventoryPage.getBurgerMenu().isDisplayed());
            Assert.assertTrue(inventoryPage.getShoppingCartButton().isDisplayed());
            Assert.assertTrue(inventoryPage.getSortButton().isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

            inventoryPage.clickBurgermenu();
            Thread.sleep(1000);
            inventoryPage.clickLogoutButton();
            Thread.sleep(1000);
            homePage.clearUsername();
            homePage.clearPassword();

            Assert.assertTrue(homePage.getLoginButton().isDisplayed());
            Assert.assertTrue(homePage.getUsername().isDisplayed());
            Assert.assertTrue(homePage.getPassword().isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        }
    }

    @Test(priority = 20)
    public void userCannotLogInWithInvalidUsername() throws InterruptedException {
        for (int i = 1; i < excelReader.getLastRow("Negative Login"); i++) {
            String invalidUsername = excelReader.getStringData("Negative Login", i, 1);
            String validPassword = excelReader.getStringData("Login", 1, 1);
            homePage.insertUsername(invalidUsername);
            homePage.insertPassword(validPassword);
            homePage.clickOnLoginButton();
//            Thread.sleep(1000);
            Assert.assertEquals(homePage.getNotificationText(), "Epic sadface: Username and password do not match any user in this service");
            Assert.assertTrue(homePage.getLoginButton().isDisplayed());
            Assert.assertTrue(homePage.getUsername().isDisplayed());
            Assert.assertTrue(homePage.getPassword().isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
//            Thread.sleep(1000);
            homePage.clearUsername();
            homePage.clearPassword();
        }
    }

    @Test(priority = 30)
    public void usercannotLogInWithInvalidPassword() throws InterruptedException {
        for (int i = 1; i < excelReader.getLastRow("Negative Login"); i++) {
            String validUsername = excelReader.getStringData("Login",1,0 );
            String invalidPassword = excelReader.getStringData("Negative Login", i, 2);
            homePage.insertUsername(validUsername);
            homePage.insertPassword(invalidPassword);
            homePage.clickOnLoginButton();
//            Thread.sleep(1000);
            Assert.assertEquals(homePage.getNotificationText(), "Epic sadface: Username and password do not match any user in this service");
            Assert.assertTrue(homePage.getLoginButton().isDisplayed());
            Assert.assertTrue(homePage.getUsername().isDisplayed());
            Assert.assertTrue(homePage.getPassword().isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
//            Thread.sleep(1000);
            homePage.clearUsername();
            homePage.clearPassword();
        }
    }

    @Test(priority = 40)
    public void usercannotLogInWithInvalidUsernameAndPassword() throws InterruptedException {
        for (int i = 1; i < excelReader.getLastRow("Negative Login"); i++) {
            String invalidUsername = excelReader.getStringData("Negative Login" ,i,1 );
            String invalidPassword = excelReader.getStringData("Negative Login", i, 2);
            homePage.insertUsername(invalidUsername);
            homePage.insertPassword(invalidPassword);
            homePage.clickOnLoginButton();
//            Thread.sleep(1000);
            Assert.assertEquals(homePage.getNotificationText(), "Epic sadface: Username and password do not match any user in this service");
            Assert.assertTrue(homePage.getLoginButton().isDisplayed());
            Assert.assertTrue(homePage.getUsername().isDisplayed());
            Assert.assertTrue(homePage.getPassword().isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
//            Thread.sleep(1000);
            homePage.clearUsername();
            homePage.clearPassword();
        }
    }

    @Test(priority = 50)
    public void userCannotLogInWithEmptyFields() throws InterruptedException {
        homePage.clearUsername();
        homePage.clearPassword();
        homePage.clickOnLoginButton();
        Thread.sleep(2000);
        Assert.assertEquals(homePage.getNotificationText(), "Epic sadface: Username is required");
        Assert.assertTrue(homePage.getLoginButton().isDisplayed());
        Assert.assertTrue(homePage.getUsername().isDisplayed());
        Assert.assertTrue(homePage.getPassword().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

    @Test(priority = 60)
    public void userCannotLogInWithEmptyUsernameField() throws InterruptedException {
        String validPassword = excelReader.getStringData("Login", 1, 1);
        homePage.clearUsername();
        homePage.clearPassword();
        homePage.insertPassword(validPassword);
        homePage.clickOnLoginButton();
//            Thread.sleep(1000);
        Assert.assertEquals(homePage.getNotificationText(), "Epic sadface: Username is required");
        Assert.assertTrue(homePage.getLoginButton().isDisplayed());
        Assert.assertTrue(homePage.getUsername().isDisplayed());
        Assert.assertTrue(homePage.getPassword().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

    @Test(priority = 70)
    public void userCannotLogInWithEmptyPasswordField() throws InterruptedException {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        homePage.clearUsername();
        homePage.clearPassword();
        homePage.insertUsername(validUsername);
        homePage.clickOnLoginButton();
//            Thread.sleep(1000);
        Assert.assertEquals(homePage.getNotificationText(), "Epic sadface: Password is required");
        Assert.assertTrue(homePage.getLoginButton().isDisplayed());
        Assert.assertTrue(homePage.getUsername().isDisplayed());
        Assert.assertTrue(homePage.getPassword().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

    }

        @Test(priority = 80)
    public void lockedOutUsersAccountInaccessible() throws InterruptedException {
        String invalidUsername = excelReader.getStringData("Negative Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        homePage.insertUsername(invalidUsername);
        homePage.insertPassword(validPassword);
        homePage.clickOnLoginButton();
        Thread.sleep(1000);
        Assert.assertEquals(homePage.getNotificationText(), "Epic sadface: Sorry, this user has been locked out.");
        Assert.assertTrue(homePage.getLoginButton().isDisplayed());
        Assert.assertTrue(homePage.getUsername().isDisplayed());
        Assert.assertTrue(homePage.getPassword().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

    }
}
