package hw8.utils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class DataProviderTools {

    //All cleaned up and well-packaged
    @SneakyThrows
    public static Object[] readObjectsFromJson(Type token, File src) {
        Map<String, Object> map = new Gson().fromJson(new JsonReader(new FileReader(src)), token);
        return map.values().toArray();
    }
}
