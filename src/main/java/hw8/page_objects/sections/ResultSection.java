package hw8.page_objects.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import junit.framework.Assert;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ResultSection extends Section {

    @FindBy(css = ".results li")
    private TextList resultList;

    public void checkResult(List<String> expectedResult) {
        expectedResult = expectedResult.stream().filter(Objects::nonNull).collect(Collectors.toList());
        List<String> log = resultList.getTextList();
        for (int i = 0; i < expectedResult.size(); i++) {
            Assert.assertEquals(
                    log.get(i).replaceAll(".*: ", ""), expectedResult.get(i)
            );
        }
    }
}
