package collection.deque.test;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {
    private Deque<String> history = new ArrayDeque<>();
    private String currentPage;
    public void visitPage(String url){
        System.out.println("방문: " + url);
        if(currentPage != null){
            history.push(currentPage);
        }
        currentPage = url;
    }

    public String goBack() {
        if(!history.isEmpty()){
            String backPage = history.pop();
            System.out.println("뒤로가기: " + backPage);
            return backPage;
        }
        return null;

    }
}
