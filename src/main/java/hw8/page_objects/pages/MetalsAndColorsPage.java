package hw8.page_objects.pages;

import hw8.page_objects.forms.MetalsAndColorsForm;
import hw8.page_objects.sections.ResultSection;
import org.openqa.selenium.support.FindBy;

public class MetalsAndColorsPage extends CommonPage {

    @FindBy(css = ".main-content form")
    public MetalsAndColorsForm metalsAndColorsForm;

    @FindBy(css = ".info-panel-body-result")
    public ResultSection resultSection;
}
