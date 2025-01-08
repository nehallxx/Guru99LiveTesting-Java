package TestsDir;

import Guru99TaskPages.MobilePage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
public class HomePageTest extends TaskSetup{

    @Test
    public void HomePageTitleTest(){
        assertTrue(homePage.isTitleVisible());
    }
    @Test
    public void MobilePageTitleTest(){
        MobilePage mobilePage=homePage.clickMobileOption();
        assertTrue(mobilePage.isTitleVisible());
        mobilePage.clickDropdown("http://live.techpanda.org/index.php/mobile.html?dir=asc&order=name");
        assertTrue(mobilePage.isSortByNameSelected());
    }

}
