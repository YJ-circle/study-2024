import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T20240926 {
    public static void main(String[] args) {
        OpenAIChat ai = new OpenAIChat("MY TOKEN");
        ai.prompt("it is test hello");
        System.out.println("ai.getContent() = " + ai.getContent());
//        //json split
//        String response = "{  \"id\": \"chatcmpl-ACI6unt6zTMQAR2j3jS36izvBzEQj\",  \"object\": \"chat.completion\",  \"created\": 1727492916,  \"model\": \"gpt-4o-mini-2024-07-18\",  \"choices\": [    {      \"index\": 0,      \"message\": {        \"role\": \"assistant\",        \"content\": \"Hello! It looks like you're testing the chat. How can I assist you today?\",        \"refusal\": null      },      \"logprobs\": null,      \"finish_reason\": \"stop\"    }  ],  \"usage\": {    \"prompt_tokens\": 19,    \"completion_tokens\": 17,    \"total_tokens\": 36,    \"completion_tokens_details\": {      \"reasoning_tokens\": 0    }  },  \"system_fingerprint\": \"fp_f85bea6784\"}";
//
//        // 각 키의 값을 추출하기 위한 정규 표현식
//        String[] keys = {"id", "object", "created", "model", "content", "prompt_tokens", "completion_tokens", "total_tokens", "system_fingerprint"};
//        for (String key : keys) {
//            String regex = String.format("\"%s\":\\s*\"?([^\",}]+)\"?", key);
//            Pattern pattern = Pattern.compile(regex);
//            Matcher matcher = pattern.matcher(response);
//
//            if (matcher.find()) {
//                System.out.println(key + ": " + matcher.group(1));
//            }
//        }

    }
}
