package hw7;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import hw7.page_objects.JDITestSite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static hw7.entities.MetalAndColorContent.EXPECTED_METALS_AND_COLORS;
import static hw7.entities.User.PITER;
import static hw7.enums.JDI_PAGES.METALS_COLORS;
import static hw7.utils.ResultLogAssembler.assembleMetalsAndColorsResult;
import static java.lang.System.setProperty;

public class Task01 extends TestNGBase {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        WebSite.init(JDITestSite.class);
        JDITestSite.indexPage.open();
    }


    @Test
    public void metalsAndColorsPageTest() {
        //1 Login on JDI site as User
        JDITestSite.indexPage.header.login(PITER);

        //2 Open Metals & Colors page by Header menu
        JDITestSite.indexPage.header.pagesMenu.select(METALS_COLORS);
        JDITestSite.metalsAndColorsPage.shouldBeOpened();

        //3 Fill form Metals & Colors by data below:
        JDITestSite.metalsAndColorsPage.metalsAndColorsForm.fill(EXPECTED_METALS_AND_COLORS);

        //4 Submit form Metals & Colors
        JDITestSite.metalsAndColorsPage.metalsAndColorsForm.submit();

        //5 Result sections should contains data  below:
        JDITestSite.metalsAndColorsPage.resultSection
                .checkResult(assembleMetalsAndColorsResult(EXPECTED_METALS_AND_COLORS));
    }
}
