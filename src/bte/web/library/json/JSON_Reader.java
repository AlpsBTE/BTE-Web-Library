package bte.web.library.json;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;

public class JSON_Reader {

    protected String API_Key = "";

    protected String jsonGetRequest(String URL) throws IOException {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();

            HttpGet request = new HttpGet("https://buildtheearth.net/api/v1/" + URL);

            request.addHeader("Authorization", "Bearer " + API_Key);
            request.addHeader("Accept", "*/*");

            CloseableHttpResponse response = httpClient.execute(request);

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String value = EntityUtils.toString(entity);
                    response.close();
                    httpClient.close();
                    return value;
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected JSONArray getJSONArray(JSONObject jsonObject, String key) {
        return jsonObject.getJSONArray(key);
    }

    protected JSONObject getJSONObject(String json) {
        return new JSONObject(json);
    }
}
