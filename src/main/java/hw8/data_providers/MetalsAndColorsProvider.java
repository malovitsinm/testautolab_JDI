package hw8.data_providers;

import hw8.entities.MetalsAndColorsContent;
import hw8.utils.DataProviderTools;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.io.File;

public class MetalsAndColorsProvider {
    @DataProvider(name = "MetalAndColorDataProvider")
    public Object[][] MetalsAndColorsFormDP(ITestContext context) {
        File src = new File(context.getCurrentXmlTest().getParameter("MetalAndColorDataProvider"));
        return DataProviderTools.provideData(DataProviderTools.readObjectsFromJson(MetalsAndColorsContent.class, src));
    }
}
