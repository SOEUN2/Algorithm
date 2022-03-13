import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int idx = 0;
        while(true){
            if(idx==completion.length){
                answer = participant[completion.length];
                break;
            }
            
            if(!completion[idx].equals(participant[idx])){
                answer = participant[idx];
                break;
            }
            
            idx++;
        }
        
        return answer;
    }
}