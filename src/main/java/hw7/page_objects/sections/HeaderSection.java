package hw7.page_objects.sections;

import com.codeborne.selenide.Condition;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import hw7.entities.User;
import hw7.enums.JDI_PAGES;
import hw7.page_objects.forms.LoginForm;
import org.openqa.selenium.support.FindBy;


public class HeaderSection extends Section {

    @FindBy(css = ".m-l8 li")
    public Menu<JDI_PAGES> pagesMenu;

    @FindBy(css = ".profile-photo")
    private Button profilePhoto;

    @FindBy(css = ".profile-photo>span")
    private Button userName;

    @FindBy(css = ".form-horizontal")
    private LoginForm loginForm;

    public void login(User user) {
        profilePhoto.click();
        loginForm.loginAs(user);
        userName.shouldHave(Condition.text(user.getName()));
    }

}
