package hw8;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import hw8.data_providers.MetalsAndColorsProvider;
import hw8.entities.MetalsAndColorsContent;
import hw8.page_objects.JDITestSite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static hw8.entities.User.PITER;
import static hw8.enums.JDI_PAGES.METALS_COLORS;
import static hw8.utils.ResultLogAssembler.assembleMetalsAndColorsResult;
import static java.lang.System.setProperty;

public class Task01 extends TestNGBase {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        WebSite.init(JDITestSite.class);
        JDITestSite.indexPage.open();
    }

    @AfterMethod
    public void tearDown() {
        JDITestSite.indexPage.header.logOut();
    }

    @Test(dataProvider = "MetalAndColorDataProvider", dataProviderClass = MetalsAndColorsProvider.class)
    public void metalsAndColorsPageTestDDT(Object entity) {
        //1 Login on JDI site as User
        JDITestSite.indexPage.header.login(PITER);

        //2 Open Metals & Colors page by Header menu
        JDITestSite.indexPage.header.pagesMenu.select(METALS_COLORS.pageName);
        JDITestSite.metalsAndColorsPage.shouldBeOpened();

        //3 Fill form Metals & Colors by data below:
        JDITestSite.metalsAndColorsPage.metalsAndColorsForm.fill((MetalsAndColorsContent) entity);

        //4 Submit form Metals & Colors
        JDITestSite.metalsAndColorsPage.metalsAndColorsForm.submit();

        //5 Result sections should contains data  below:
        JDITestSite.metalsAndColorsPage.resultSection
                .checkResult(assembleMetalsAndColorsResult((MetalsAndColorsContent) entity));
    }
}
