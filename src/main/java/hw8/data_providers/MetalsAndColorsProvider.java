package hw8.data_providers;

import com.google.common.reflect.TypeToken;
import hw8.entities.MetalsAndColorsContent;
import hw8.utils.DataProviderTools;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.lang.reflect.Type;
import java.util.Map;

public class MetalsAndColorsProvider {
    @DataProvider(name = "MetalAndColorDataProvider")
    public Object[] MetalsAndColorsFormDP(ITestContext context) {
        File src = new File(context.getCurrentXmlTest().getParameter("MetalAndColorDataProvider"));
        Type token = new TypeToken<Map<String, MetalsAndColorsContent>>() {{
        }}.getType();
        return DataProviderTools.readObjectsFromJson(token, src);
    }
}
