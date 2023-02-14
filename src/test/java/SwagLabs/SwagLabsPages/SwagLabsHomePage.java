package SwagLabs.SwagLabsPages;

import SwagLabs.SwagLabsBase.SwagLabsBaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsHomePage extends SwagLabsBaseTest {

    public SwagLabsHomePage() { PageFactory.initElements(driver, this);}

    @FindBy(id = "user-name")
    public WebElement Username;

    @FindBy(id = "password")
    public WebElement Password;

    @FindBy(id="login-button")
    public WebElement LoginButton;

    public WebElement getLoginButton() {
        return LoginButton;
    }

    public WebElement getUsername() { return Username; }

    public WebElement getPassword() { return Password; }

    //--------------------------------


    @FindBy(css = "h3[data-test=error]")
    public WebElement notification;

    public String getNotificationText() {
        return notification.getText();
    }


    //---------------------------------

    public void insertUsername(String username) {
        Username.clear();
        Username.sendKeys(username);
    }

    public void insertPassword(String password) {
        Password.clear();
        Password.sendKeys(password);
    }

    public void clickOnLoginButton(){
        LoginButton.click();
    }

    public void clearUsername(){Username.clear();}

    public void clearPassword(){Password.clear();}

}
