package hw7.page_objects.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.ComboBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JComboBox;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import hw7.entities.MetalAndColorContent;
import org.openqa.selenium.support.FindBy;

public class MetalsAndColorsForm extends Form<MetalAndColorContent> {
    @FindBy(css = "#odds-selector .radio")
    private RadioButtons oddNumbers;

    @FindBy(css = "#even-selector .radio")
    private RadioButtons evenNumbers;

    @FindBy(css = "#elements-checklist label")
    private CheckList natureElements;

    @JDropdown(root = @FindBy(css = ".colors"),
            list = @FindBy(css = "li"),
            value = @FindBy(css = ".filter-option")
    )
    private Dropdown colors;

    @JComboBox(root = @FindBy(css = ".metals"),
            list = @FindBy(css = "li"),
            value = @FindBy(css = ".filter-option"),
            expand = @FindBy(css = ".caret")
    )
    private ComboBox metals;

    @FindBy(css = "#salad-dropdown button")
    private Label saladLabel;

    @FindBy(css = "#salad-dropdown a")
    private CheckList vegetables;

    @FindBy(css = "#submit-button")
    private Button submit;

    @Override
    public void fill(MetalAndColorContent entity) {
        oddNumbers.select(entity.getNumbers().x.toString());
        evenNumbers.select(entity.getNumbers().y.toString());
        colors.select(entity.getColor());
        metals.select(entity.getMetal());
        entity.getNatureElements().forEach(element -> natureElements.check(element));

        saladLabel.click();
        /*NOTE TO REVIEWER:
        * It seems that clear() method simply does not seem to work on any of CheckLists
        * (Neither then called explicitly or implicitly from check() method).
        * Thus the default option is unchecked manually. If there's a better workaround please inform me.
        * I wonder if this trouble links to the way I've wrote lists' locators.
        * */
//        vegetables.clear();
        vegetables.check(saladLabel.getText());
        entity.getVegetables().forEach(saladOption -> vegetables.check(saladOption));
    }

    public void submit() {
        submit.click();
    }

}
