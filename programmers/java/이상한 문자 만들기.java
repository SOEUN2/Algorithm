import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] temp = s.split("");
        int idx = 0;
        
        for(int i=0;i<s.length();i++){
            if(temp[i].equals(" ")){
                answer += temp[i];
                idx = 0;
            }else if(idx%2==0){
                answer += temp[i].toUpperCase();
                idx++;
            }else if(idx%2!=0){
                answer += temp[i].toLowerCase();
                idx++;
            }
        }
        
        return answer;
    }
}