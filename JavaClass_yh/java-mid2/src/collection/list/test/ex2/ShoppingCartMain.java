package collection.list.test.ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShoppingCartMain {
    public static void main(String[] args) throws IOException {
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("마늘", 2000, 2);
        Item item2 = new Item("상추", 3000, 4);
        cart.addItem(item1);
        cart.addItem(item2);
        cart.displayItems();

        URL url = new URL("https://namu.wiki/w/%EC%B6%95%EA%B5%AC");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
//        System.out.println("response.toString() = " + response.toString());

        Pattern regex = Pattern.compile("(?s)개요.*?</div>");
        Matcher regexMatcher = regex.matcher(response);
        StringBuilder st = new StringBuilder();
        while(regexMatcher.find()){
            st.append(regexMatcher.group());
        }

        String text = st.toString();
        System.out.println("text = " + text);


    }
}
