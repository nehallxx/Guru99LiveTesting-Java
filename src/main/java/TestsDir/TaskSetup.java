package TestsDir;

import Guru99TaskPages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class TaskSetup {
    public WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void Setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://live.techpanda.org/index.php/");
        homePage = new HomePage(driver);
    }


    @AfterMethod
    public void TearDown(){
//        driver.quit();
    }
}
