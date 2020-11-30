package bte.web.library.models;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class Application {

    private final int ID;

    private final Map<String, String> QUESTIONS = new HashMap<>();
    private final Map<String, String> ANSWERS = new HashMap<>();

    public Application(int ID, JSONArray answers) {

        // Get ID of the Application
        this.ID = ID;

        // Get Questions and Answers of the Application
        JSONObject object;
        for (int i = 0; i < answers.length(); i++) {
            object = answers.getJSONObject(i);
            this.QUESTIONS.put(String.valueOf(object.getInt("id")), object.getString("question"));
            this.ANSWERS.put(String.valueOf(object.getInt("id")), object.getString("answer"));
        }
    }

    public int getID() {
        return ID;
    }

    public Map<String, String> getQuestions() {
        return QUESTIONS;
    }

    public Map<String, String> getAnswers() {
        return ANSWERS;
    }
}
