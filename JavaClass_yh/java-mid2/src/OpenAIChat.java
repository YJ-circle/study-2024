
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenAIChat {
    private static String API_KEY;
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private String stringResponse;
    private Object jsonResponse;

    public OpenAIChat(String key) {
        API_KEY = key;
    }

    public String prompt(String request) {
        try {
            // JSON payload 생성
            String jsonInputString = "{"
                    + "\"model\": \"gpt-4o-mini\","
                    + "\"messages\": ["
                    + "{ \"role\": \"system\", \"content\": \"You are useful assistant\" },"
                    + "{ \"role\": \"user\", \"content\": \""
                    + request
                    + "\"}"
                    + "]}";


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
            String resultMsg = getResponseString(response);


            return resultMsg;
            // 필요한 데이터 추출
//            String messageContent = jsonObject.jso
//            System.out.println("Response: " + messageContent);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getResponseString(StringBuilder response) throws ParseException {
        return response.toString();
    }
    public JSONObject getResponseJson(String stringResponse) {
        JSONParser parser = new JSONParser();
        JSONObject responseObject = null;
        try {
            responseObject = (JSONObject) parser.parse(stringResponse.toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return responseObject;
    }

//    public void getETC(){
//        JSONArray choicesArray = (JSONArray) responseObject.get("choices");
//        System.out.println("choicesArray = " + choicesArray);
//        JSONObject firstChoice = (JSONObject) choicesArray.get(0);
//        System.out.println("firstChoice = " + firstChoice);
//        JSONObject messageObject = (JSONObject) firstChoice.get("message");
//        System.out.println("messageObject = " + messageObject);
//        String resultMsg = (String) messageObject.get("content");
//        System.out.println("resultMsg = " + resultMsg);
////        return resultMsg;
//    }

    private void resp(StringBuilder response){


    }
}
