package hw7.page_objects.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import hw7.entities.User;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<User> {
    @FindBy(css = "#Login")
    private TextField login;

    @FindBy(css = "#Password")
    private TextField password;

    @FindBy(css = "[type=submit]")
    private Button enter;
}
