package hw8.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileReader;
import java.util.Map;

public class DataProviderTools {

    @SneakyThrows
    public static <T> Object[] readObjectsFromJson(Class<T> tClass, File src) {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        Object[] arObject;

        try (FileReader srcReader = new FileReader(src)) {
            JsonElement root = parser.parse(srcReader);
            JsonObject rootObj = root.getAsJsonObject();
            arObject = rootObj.entrySet().stream().map(Map.Entry::getValue)
                    .map(jsonObject -> gson.fromJson(jsonObject, tClass)).toArray();
        }

        return arObject;
    }

    public static Object[][] provideData(Object... arObj) {
        Object[][] arObject = new Object[arObj.length][];

        int index = 0;
        for (Object obj : arObj) {
            arObject[index++] = new Object[]{obj};
        }
        return arObject;
    }
}
