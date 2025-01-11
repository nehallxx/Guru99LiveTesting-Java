package Guru99TaskPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
//   Elements Locators
    private By homePageTitle=By.tagName("h2");
    private By mobileList=By.cssSelector(".level0.nav-1.first");

    public HomePage(WebDriver driver){
               this.driver=driver;
               this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
           }

    public boolean isTitleVisible(){
               wait.until(ExpectedConditions.visibilityOfElementLocated(homePageTitle));
               return driver.findElement(homePageTitle).isDisplayed();
           }

           // move to Mobile page and give it the same driver
    public MobilePage clickMobileOption(){
               wait.until(ExpectedConditions.presenceOfElementLocated(mobileList));
               driver.findElement(mobileList).click();
               return new MobilePage(driver);
          }

}


