import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OpenAIChat {
    private static String API_KEY;
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private String stringResponse;

    public OpenAIChat(String key) {
        API_KEY = key;
    }

    public String prompt(String request) {
        try {
            String jsonInputString = "{"
                    + "\"model\": \"gpt-4o-mini\","
                    + "\"messages\": ["
                    + "{ \"role\": \"system\", \"content\": \"You are useful assistant\" },"
                    + "{ \"role\": \"user\", \"content\": \""
                    + request
                    + "\"}"
                    + "]}";


            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + API_KEY);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

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
            stringResponse = response.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getContent(){
        String regex = String.format("\"%s\":\\s*\"?([^\",}]+)\"?", "content");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(stringResponse);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
