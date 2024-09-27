public class T20240926 {
    public static void main(String[] args) {
        OpenAIChat ai = new OpenAIChat("");
        ai.prompt("Korean vs English questions " +
                "Which one is cheaper?");
    }
}
