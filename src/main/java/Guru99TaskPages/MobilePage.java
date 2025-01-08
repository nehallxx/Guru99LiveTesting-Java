package Guru99TaskPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MobilePage {
    private WebDriver driver;
    private WebDriverWait wait;
// Elements Locators
    private By mobileTitle= By.cssSelector(".page-title.category-title");
    private By DropdownMenu= By.cssSelector("select[title='Sort By']");
    private By nameOption= By.xpath("//select[@title='Sort By']/option[text()='Name']");

//    Constructor
    public MobilePage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }

// Tests Implementations
    public boolean isTitleVisible(){
        wait.until(ExpectedConditions.presenceOfElementLocated(mobileTitle));
        return driver.findElement(mobileTitle).isDisplayed();
    }

    public void clickDropdown(String SelectedOption) {
        wait.until(ExpectedConditions.presenceOfElementLocated(DropdownMenu));
        WebElement dropdownOption = driver.findElement(DropdownMenu);
        Select nameOption = new Select(dropdownOption);
        nameOption.selectByValue(SelectedOption);
    }

    public boolean isSortByNameSelected() {
        wait.until(ExpectedConditions.presenceOfElementLocated(DropdownMenu));
        WebElement dropdownElement = driver.findElement(DropdownMenu);
        Select nameOption = new Select(dropdownElement);
        WebElement selectedOption = nameOption.getFirstSelectedOption();
        return selectedOption.getText().trim().equals("Name");
    }

}
