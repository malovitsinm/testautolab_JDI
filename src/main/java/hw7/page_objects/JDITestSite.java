package hw7.page_objects;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import hw7.page_objects.pages.IndexPage;
import hw7.page_objects.pages.MetalsAndColorsPage;

@JSite("https://jdi-framework.github.io/tests")
public class JDITestSite extends WebSite {

    @JPage(url = "index.htm", title = "Index Page")
    public static IndexPage indexPage;

    @JPage(value = "page2.htm", title = "Metal and Colors")
    public static MetalsAndColorsPage metalsAndColorsPage;
}
