package SwagLabs.SwagLabsPages;

import SwagLabs.SwagLabsBase.SwagLabsBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsCartPage extends SwagLabsBaseTest {

    public SwagLabsCartPage() { PageFactory.initElements(driver, this);}


    @FindBy(css = ".btn.btn_secondary.btn_small.cart_button")
    public WebElement removeButton;

    @FindBy(id="continue-shopping")
    public WebElement continueShoppingButton;

    @FindBy(id="checkout")
    public WebElement checkOutButton;

    //----------------------------------------

    public void clickOnRemoveButton(){
        removeButton.click();
    }

    public void clickOnContinueShoppingButton(){
        continueShoppingButton.click();
    }
}
