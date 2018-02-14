package hw8.page_objects.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.ComboBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JComboBox;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import hw8.entities.MetalsAndColorsContent;
import org.openqa.selenium.support.FindBy;
import org.testng.util.Strings;

public class MetalsAndColorsForm extends Form<MetalsAndColorsContent> {
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
    private Dropdown colors = new Dropdown() {
        @Override // TODO
        protected void selectAction(String name) {
            if (!Strings.isNullOrEmpty(name))
                super.selectAction(name);
        }
    };

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
    public void fill(MetalsAndColorsContent entity) {
        // TODO a think it will be better if you create your own elements
        // TODO and check data on theirs method, like "colors" element
        if (!entity.getSummary().isEmpty()) {
            oddNumbers.select(entity.getSummary().get(0).toString());
            evenNumbers.select(entity.getSummary().get(1).toString());
        }
        colors.select(entity.getColor());
//        if (!entity.getColor().isEmpty()) colors.select(entity.getColor());
        if (!entity.getMetals().isEmpty()) metals.select(entity.getMetals());
        if (!entity.getElements().isEmpty())
            natureElements.check(entity.getElements().toArray(new String[entity.getElements().size()]));
        /*NOTE TO REVIEWER:
         * It seems that clear() method simply does not seem to work on any of CheckLists
         * (Neither then called explicitly or implicitly from check() method).
         * Thus the default option is unchecked manually. If there's a better workaround please inform me.
         * I wonder if this trouble links to the way I've wrote lists' locators.
         * */
//        vegetables.clear();
        // TODO create your own element within "clear" method
        // TODO you should check the property of the each option and figure out their status (selected or not)
        if (!entity.getVegetables().isEmpty()) {
            saladLabel.click();
            vegetables.check(saladLabel.getText());
            vegetables.check(entity.getVegetables().toArray(new String[entity.getVegetables().size()]));
        }
    }

    public void submit() {
        submit.click();
    }

}
