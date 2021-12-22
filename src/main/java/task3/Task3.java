package task3;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class Task3 {
    public static void main(String[] args) throws IOException {
        String tests = Files.readString(Path.of(args[0]), StandardCharsets.US_ASCII);
        JSONObject testsJson = new JSONObject(tests);

        String values = Files.readString(Path.of(args[1]), StandardCharsets.US_ASCII);
        JSONObject valuesJson = new JSONObject(values);
        JSONArray valuesArray = valuesJson.getJSONArray("values");
        HashMap<Integer, String> valuesMap = new HashMap<>();

        for (Object value : valuesArray) {
            JSONObject valueJson = (JSONObject)value;
            valuesMap.put(valueJson.getInt("id"), valueJson.getString("value"));
        }

        JSONArray testsArray = testsJson.getJSONArray("tests");
        fillTests(testsArray, valuesMap);
        Files.write(Path.of("D:\\Fisker\\Desktop\\report.json"), testsJson.toString(2).getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Рекурсивный метод проходящий по массиву tests и заполняет значениями.
     * @param testsArray массив json
     * @param valuesMap Map со значениями
     */
    private static void fillTests(JSONArray testsArray, HashMap<Integer, String> valuesMap) {
        for (Object test : testsArray) {
            JSONObject testJson = (JSONObject) test;
            int id = testJson.getInt("id");
            String value = valuesMap.get(id);
            testJson.put("value", value);
            if (testJson.has("values")) {
                fillTests(testJson.getJSONArray("values"),valuesMap);
            }
        }
    }
}