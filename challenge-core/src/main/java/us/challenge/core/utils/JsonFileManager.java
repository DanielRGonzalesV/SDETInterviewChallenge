package us.challenge.core.utils;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.invoke.MethodHandles;

public class JsonFileManager {
    /**
     * Read json file and convert to JsonObject
     *
     * @return JsonObject
     */
    public static JsonObject getJsonObject(String pathFile) {
        String PATH_JSON = "json-data";
        InputStream inputStream = MethodHandles.lookup().lookupClass().getClassLoader()
                .getResourceAsStream(PATH_JSON.concat(File.separator).concat(pathFile));
        Reader reader = new InputStreamReader(inputStream);
        JsonParser parser = new JsonParser();
        return parser.parse(reader).getAsJsonObject();
    }

//    public JsonObject getDataSearch() {
////        return JsonFileManager.getJsonObject(PSP_TEMPLATE_PATH.concat(File.separator).concat(pspIBar)
////        .concat(File.separator).concat(pspIBar).concat(".json"));
//    }

    public static String getValueData(String key){
//        JsonObject jsonObject = getJsonObject(PSP_TEMPLATE_PATH.concat(File.separator).concat(pspIBar)
//        .concat(File.separator).concat(pspIBar).concat(".json")).get(key).get()
        return "";
//        return assignmentsJsonObject.get("expectedHoursToWork").getAsInt();
    }
}
