package SwagLabs.SwagLabsBase;

import SwagLabs.SwagLabsPages.SwagLabsCartPage;
import SwagLabs.SwagLabsPages.SwagLabsHomePage;
import SwagLabs.SwagLabsPages.SwagLabsInventoryPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class SwagLabsBaseTest {

    public static WebDriver driver;
    public WebDriverWait wdwait;
    public ExcelReader excelReader;
    public String loginURL;
    public SwagLabsHomePage homePage;
    public SwagLabsInventoryPage inventoryPage;
    public SwagLabsCartPage cartPage;

    @BeforeClass
            public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        excelReader = new ExcelReader("src/test/java/SwagLabs/TestData.xlsx");
        loginURL = excelReader.getStringData("URL", 1, 0);
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void waitForVisibility(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void logIn(){
        driver.manage().window().maximize();
        driver.get(loginURL);
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        homePage.insertUsername(validUsername);
        homePage.insertPassword(validPassword);
        homePage.clickOnLoginButton();
    }

}
