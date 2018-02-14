package hw8.page_objects.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import hw8.page_objects.sections.HeaderSection;
import org.openqa.selenium.support.FindBy;

public class CommonPage extends WebPage {
    @FindBy(css = "header")
    public HeaderSection header;
}
