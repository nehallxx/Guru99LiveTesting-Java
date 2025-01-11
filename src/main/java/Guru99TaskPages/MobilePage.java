package Guru99TaskPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class MobilePage {
    private WebDriver driver;
    private WebDriverWait wait;
    // Elements Locators
    private By mobileTitle = By.cssSelector(".page-title.category-title");
    private By DropdownMenu = By.cssSelector("select[title='Sort By']");
    private By clickedOption = By.xpath("//select[@title='Sort By']/option[text()='Name']");
    private By sonyPrice = By.id("product-price-1");
    private By sonyPage = By.cssSelector("a[title='Sony Xperia']");
    private By addSonyToCartButton = By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button");
    private By addToCompare = By.cssSelector("a[class=\"link-compare\"]");
    private By compareBtn=By.cssSelector("button[title=\"Compare\"]");
    private By popupWindow=By.tagName("body");

    //    Constructor
    public MobilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Tests Implementations
    public boolean isTitleVisible() {
        wait.until(ExpectedConditions.presenceOfElementLocated(mobileTitle));
        return driver.findElement(mobileTitle).isDisplayed();
    }

    public void clickDropdown(String SelectedOption) {
        wait.until(ExpectedConditions.presenceOfElementLocated(DropdownMenu));
        WebElement dropdownOption = driver.findElement(DropdownMenu);
        Select clickedOption = new Select(dropdownOption);
        clickedOption.selectByValue(SelectedOption); //this function clicks on the selected option
    }

    public boolean isSortByNameSelected() {
        wait.until(ExpectedConditions.presenceOfElementLocated(DropdownMenu));
        WebElement dropdownElement = driver.findElement(DropdownMenu);
        Select nameOption = new Select(dropdownElement);
        WebElement selectedOption = nameOption.getFirstSelectedOption();
        return selectedOption.getText().trim().equals("Name");
    }

    public String getSonyPriceFromMobilePage() {
        wait.until((ExpectedConditions.presenceOfElementLocated(sonyPrice)));
        return driver.findElement(sonyPrice).getText();
    }

    public SonyPage goToSonyPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(sonyPage));
        driver.findElement(sonyPage).click();
        return new SonyPage(driver);
    }

    public ShoppingCartPage addSonyToCart() {
        wait.until(ExpectedConditions.presenceOfElementLocated(addSonyToCartButton));
        driver.findElement(addSonyToCartButton).click();
        return new ShoppingCartPage(driver);
    }

    public void AddItemsToCompare(){
        wait.until(ExpectedConditions.presenceOfElementLocated(addToCompare));
        for(int i=0;i<2;i++){
            List <WebElement> mobiles= driver.findElements(addToCompare);
            mobiles.get(i).click();;
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(compareBtn));
        driver.findElement(compareBtn).click();
        String mainWindowHandel= driver.getWindowHandle(); //to get current -main- window handle
        Set <String> windowHandels=driver.getWindowHandles();
        for(String wHandel: windowHandels){
            if(!wHandel.equals(mainWindowHandel)){
                driver.switchTo().window(wHandel);
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(popupWindow));
        File destinationFile = new File("popup_screenshot.png");
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshotFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved to: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.close();
        driver.switchTo().window(mainWindowHandel);
    }

}
