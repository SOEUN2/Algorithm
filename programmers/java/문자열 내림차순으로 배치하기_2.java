import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";

        String[] cArray = new String[s.length()];
        cArray = s.split("");
     
        Arrays.sort(cArray, Collections.reverseOrder());
        
        for(int i=0;i<cArray.length;i++){
            answer += cArray[i];
        }
        
        return answer;
    }
}