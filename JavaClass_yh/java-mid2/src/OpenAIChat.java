import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenAIChat {
    private static final String API_KEY = "";
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";

    public static void main(String[] args) {
        try {
            // JSON payload 생성
            String jsonInputString = "{"
                    + "\"model\": \"gpt-4o-mini\","
                    + "\"messages\": ["
                    + "{ \"role\": \"system\", \"content\": \"You are a master of quotes\" },"
                    + "{ \"role\": \"user\", \"content\": \"famous saying " +
                    "Only one Briefly in Korean " +
                    "return it in the form as below. " +
                    "{msg: wise words}\" }"
                    + "]"
                    + "}";


            // URL 객체 생성
            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + API_KEY);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // 요청 본문 작성
            try (OutputStream os = conn.getOutputStream()) {
                os.write(jsonInputString.getBytes());
                os.flush();
            }

            // 응답 읽기
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // 응답 처리
            String jsonResponse = response.toString();
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse);
            String resultMsg = (String)((JSONObject)((JSONObject) ((JSONArray) jsonObject.get("choices")).get(0)).get("message")).get("content");
            System.out.println("resultMsg = " + resultMsg);
            // 필요한 데이터 추출
//            String messageContent = jsonObject.jso
//            System.out.println("Response: " + messageContent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
