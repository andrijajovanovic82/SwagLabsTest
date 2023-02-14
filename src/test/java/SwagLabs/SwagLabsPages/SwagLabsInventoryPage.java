package SwagLabs.SwagLabsPages;

import SwagLabs.SwagLabsBase.SwagLabsBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SwagLabsInventoryPage extends SwagLabsBaseTest {

    public SwagLabsInventoryPage() { PageFactory.initElements(driver, this);}

    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerMenu;

//    @FindBy(className = "bm-item menu-item")
//    public List<WebElement> burgerMenuItems;
//
//    public List<WebElement> getBurgerMenuItems() {
//        return burgerMenuItems;
//    }
//
//    public void printBurgerMenuItems(){
//        for (int i = 0; i < getBurgerMenuItems().size(); i++) {
//            System.out.println(getBurgerMenuItems().get(i).getText());
//        }
//    }
//    public void clickBurgerMenuItem(String item) {
//        for (int i = 0; i < getInventoryItems().size(); i++) {
//            if (getInventoryItems().get(i).getText().equals(item)) {
//                getInventoryItems().get(i).click();
//                break;
//            }
//        }
//    }

    @FindBy(id = "inventory_sidebar_link")
    public WebElement allItemsButton;
    @FindBy(id = "about_sidebar_link")
    public WebElement aboutButton;
    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutButton;
    @FindBy(id = "reset_sidebar_link")
    public WebElement resetButton;

    public WebElement getBurgerMenu() {
        return burgerMenu;
    }

    public void clickBurgermenu() {
        burgerMenu.click();
    }
    public void clickAllItemsButton() {
        allItemsButton.click();
    }
    public void clickAboutButton() {
        aboutButton.click();
    }
    public void clickLogoutButton() {
        logoutButton.click();
    }
    public void clickResetAPPStateButton() {
        resetButton.click();
    }

    //----------------------------------

    @FindBy(className = "product_sort_container")
    public WebElement sortButton;

    public WebElement getSortButton() {
        return sortButton;
    }

    @FindBy(css = "option[value='za']")
    public WebElement sortZToAButton;
    @FindBy(css = "option[value='az']")
    public WebElement sortAToZButton;
    @FindBy(css = "option[value='lohi']")
    public WebElement sortLowToHighButton;
    @FindBy(css = "option[value='hilo']")
    public WebElement sortHighToLowButton;

    public void clickSortButton() {
        sortButton.click();
    }
    public void clickSortZToAButton() {
        sortZToAButton.click();
    }
    public void clickSortAToZButton() {
        sortAToZButton.click();
    }
    public void clickSortLowToHighButton() {
        sortLowToHighButton.click();
    }
    public void clickSortHighToLowButton() {
        sortHighToLowButton.click();
    }

    @FindBy(className = "inventory_item_name")
    public List<WebElement> inventoryItems;

    public List<WebElement> getInventoryItems() {
        return inventoryItems;
    }

    public void inventoryPrint() {
        for (int i = 0; i < getInventoryItems().size(); i++) {
            System.out.println(getInventoryItems().get(i).getText());
        }
    }
    public void inventoryAssertOrderByName(String item) {
        boolean check = false;
        if (getInventoryItems().get(0).getText().equals(item)) {
            check = true;
        }
        Assert.assertTrue(check);
    }

    //----------------------------------

    @FindBy(className = "social_twitter")
    public WebElement twitter;
    @FindBy(className = "social_facebook")
    public WebElement facebook;
    @FindBy(className = "social_linkedin")
    public WebElement linkedIn;

    public void clickOnTwitterButton() {
        twitter.click();
    }
    public void clickOnFacebookButton() {
        facebook.click();
    }
    public void clickOnLinkedInButton() {
        linkedIn.click();
    }
    public void assertSocialMedia(String url) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        Assert.assertEquals(driver.switchTo().window(tabs.get(1)).getCurrentUrl(), url);
        driver.switchTo().window(tabs.get(1)).close();
        driver.switchTo().window(tabs.get(0));
    }

    //------------------------------------


    @FindBy(id = "shopping_cart_container")
    public WebElement shoppingCartButton;

    public WebElement getShoppingCartButton() { return shoppingCartButton; }

    public void addToCart(String item) {
        for (int i = 0; i < getInventoryItems().size(); i++) {
            if (getInventoryItems().get(i).getText().equals(item)) {
                getInventoryItems().get(i).click();
                break;
            }
        }
    }
    @FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
    public WebElement addToCartFleeceJacket;

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    public WebElement addToCartBackpack;

    @FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
    public WebElement addToCartBoltTShirt;

    public void clickOnAddToCartFleeceJacket(){addToCartFleeceJacket.click();}
    public void clickOnAddToCartBackpack(){addToCartBackpack.click();}
    public void clickOnAddToCartBoltTShirt(){ addToCartBoltTShirt.click(); }
    public void clickOnShoppingCart(){ shoppingCartButton.click(); }

}
