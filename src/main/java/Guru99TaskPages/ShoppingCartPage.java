package Guru99TaskPages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ShoppingCartPage{
         WebDriver driver;
         WebDriverWait wait;
         private By shoppingCartPageTitle= By.tagName("h1");
         private By sonyQty = By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/input");
         private By updateBtn=By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/button");
         private By errMsg=By.cssSelector(".item-msg.error");
         private By emptyCart=By.cssSelector("button[class=\"button2 btn-empty\"]");
         private By emptyCartTitle=By.cssSelector("div[class=\"page-title\"]");
    public ShoppingCartPage(WebDriver driver){
               this.driver=driver;
               this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
           }
                 // make sure i'm in cart page
    public boolean isShoppingCartTitleVisible(){
               wait.until(ExpectedConditions.presenceOfElementLocated(shoppingCartPageTitle));
               return driver.findElement(shoppingCartPageTitle).isDisplayed();
           }
    public void updateSonyQty(){
                wait.until(ExpectedConditions.visibilityOfElementLocated(sonyQty));
                driver.findElement(sonyQty).click();
                driver.findElement(sonyQty).clear();
                driver.findElement(sonyQty).sendKeys("1000");
                // Wait for the update button to be clickable and click it
               wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
             driver.findElement(updateBtn).click();
           }
    public boolean isErrMsgVisible(){
              wait.until(ExpectedConditions.presenceOfElementLocated(errMsg));
              return driver.findElement(errMsg).isDisplayed();
          }
    public void emptyCart(){
                wait.until(ExpectedConditions.presenceOfElementLocated(emptyCart));
                driver.findElement(emptyCart).click();
            }

    public boolean isEmptyCartMsgVisible(){
        wait.until(ExpectedConditions.presenceOfElementLocated(emptyCartTitle));
        return driver.findElement(emptyCartTitle).isDisplayed();
    }
}
