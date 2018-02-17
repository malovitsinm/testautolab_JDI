package hw8.elements;

import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;

import java.util.Arrays;

public class DropdownCheckList extends Dropdown {

    public void select(String... options) {
        if (options.length != 0) {
            Arrays.asList(this.getText().split(", ")).forEach(super::select);
            Arrays.asList(options).forEach(super::select);
        }
    }

}
