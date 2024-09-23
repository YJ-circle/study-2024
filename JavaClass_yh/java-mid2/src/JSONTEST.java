import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONTEST {
    public static void main(String[] args) throws ParseException {
        String json = "{\"created\":1727072284,\"usage\":{\"completion_tokens\":9,\"prompt_tokens\":19,\"completion_tokens_details\":{\"reasoning_tokens\":0},\"total_tokens\":28},\"model\":\"gpt-4o-mini-2024-07-18\",\"id\":\"chatcmpl-AAWgWaHlRmZC8WAoXNLsHu0dnHh2H\",\"choices\":[{\"finish_reason\":\"stop\",\"index\":0,\"message\":{\"role\":\"assistant\",\"refusal\":null,\"content\":\"Hello! How can I assist you today?\"},\"logprobs\":null}],\"system_fingerprint\":\"fp_1bb46167f9\",\"object\":\"chat.completion\"}\n";
        JSONParser parser = new JSONParser();
        JSONObject ja = (JSONObject) parser.parse(json);
        System.out.println(ja.keySet());
        Object jarray = ((JSONObject)((JSONObject) ((JSONArray) ja.get("choices")).get(0)).get("message")).get("content");
        System.out.println("jarray = " + jarray);
    }
}
