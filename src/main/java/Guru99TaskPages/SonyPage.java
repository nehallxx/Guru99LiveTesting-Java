package Guru99TaskPages;
     import org.openqa.selenium.By;
     import org.openqa.selenium.WebDriver;
     import org.openqa.selenium.support.ui.ExpectedConditions;
     import org.openqa.selenium.support.ui.WebDriverWait;

     import java.time.Duration;

     public class SonyPage {
         private WebDriver driver;
         private WebDriverWait wait;
         private By sonyPriceFromDetailPage= By.id("product-price-1");

         public SonyPage(WebDriver driver){
             this.driver=driver;
             this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
         }

         public String getSonyPriceFromDetailPage(){
             wait.until(ExpectedConditions.presenceOfElementLocated(sonyPriceFromDetailPage));
             return driver.findElement(sonyPriceFromDetailPage).getText();
         }


     }


