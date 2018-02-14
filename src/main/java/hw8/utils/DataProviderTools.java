package hw8.utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import hw8.entities.MetalsAndColorsContent;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class DataProviderTools {

    @SneakyThrows
    public static <T> Object[] readObjectsFromJson(Class<T> tClass, File src) {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        Object[] arObject;

        // TODO maybe this is a bit easier...
//        Type token = new TypeToken<Map<String, MetalsAndColorsContent>>() {{
//        }}.getType();
//        Map<String, MetalsAndColorsContent> map = new Gson().fromJson(new JsonReader(new FileReader(src)), token);
//        map.values();

        try (FileReader srcReader = new FileReader(src)) {
            JsonElement root = parser.parse(srcReader);
            JsonObject rootObj = root.getAsJsonObject();
            arObject = rootObj.entrySet().stream().map(Map.Entry::getValue)
                    .map(jsonObject -> gson.fromJson(jsonObject, tClass)).toArray();
        }

        return arObject;
    }

    // TODO what the point of two-dem array ? Is the 19line array not enough ?
    public static Object[][] provideData(Object... arObj) {
        Object[][] arObject = new Object[arObj.length][];

        int index = 0;
        for (Object obj : arObj) {
            arObject[index++] = new Object[]{obj};
        }
        return arObject;
    }
}
