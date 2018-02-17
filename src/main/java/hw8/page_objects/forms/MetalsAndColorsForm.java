package hw8.page_objects.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.ComboBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JComboBox;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import hw8.elements.DropdownCheckList;
import hw8.entities.MetalsAndColorsContent;
import org.openqa.selenium.support.FindBy;
import org.testng.util.Strings;

public class MetalsAndColorsForm extends Form<MetalsAndColorsContent> {
    @FindBy(css = "#odds-selector .radio")
    private RadioButtons oddNumbers;

    @FindBy(css = "#even-selector .radio")
    private RadioButtons evenNumbers;

    @FindBy(css = "#elements-checklist label")
    private CheckList natureElements = new CheckList() {
        @Override
        protected void selectListAction(String... names) {
            if (names != null && names.length != 0)
                super.selectListAction(names);
        }
    };

    @JDropdown(root = @FindBy(css = ".colors"),
            list = @FindBy(css = "li"),
            value = @FindBy(css = ".filter-option")
    )
    private Dropdown colors = new Dropdown() {
        @Override
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
    private ComboBox metals = new ComboBox() {
        @Override
        protected void selectAction(String name) {
            if (!Strings.isNullOrEmpty(name))
                super.selectAction(name);
        }
    };

    @JDropdown(
            root = @FindBy(css = "#salad-dropdown"),
            value = @FindBy(css = ".btn"),
            list = @FindBy(css = ".checkbox"),
            expand = @FindBy(css = ".caret")
    )
    private DropdownCheckList vegetables;

    @FindBy(css = "#submit-button")
    private Button submit;

    @Override
    public void fill(MetalsAndColorsContent entity) {
        // DONE a think it will be better if you create your own elements
        // DONE and check data on theirs method, like "colors" element
        if (entity.getSummary().size() == 2) {
            oddNumbers.select(entity.getSummary().get(0).toString());
            evenNumbers.select(entity.getSummary().get(1).toString());
        }
        natureElements.check(entity.getElements().toArray(new String[entity.getElements().size()]));
        colors.select(entity.getColor());
        metals.select(entity.getMetals());
        vegetables.select(entity.getVegetables().toArray(new String[entity.getVegetables().size()]));

    }

    public void submit() {
        submit.click();
    }

}
