package generic.test.ex2;

public class Solution {
    private int mode = 0;
    private StringBuilder str = new StringBuilder();

    public String solution(String code) {
        for(int i=0; i<code.length(); i++){
            char c = code.charAt(i);
            if(c=='1'){
                changeMode();
            } else{
                addString(i, c);
            }
        }
        if(str.length() ==0){
            return "EMPTY";
        }
        return str.toString();
    }

    private void changeMode(){
        mode = (mode == 0 ? 1 : 0);
    }

    private void addString(int idx, char c){
        if(idx%2 == 0){
            idx = 2;
        } else{
            idx = 1;
        }

        //mode == 0 + 짝수면
        // mode == 1 + 홀수면
        if(mode == 0 && idx != 2){ return; }
        else if (mode == 1 && idx != 1){ return;}
        str.append(c);
    };
}