import java.util. *;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        answer += Character.toUpperCase(s.charAt(0));
        
        for(int i=1; i<s.length();i++){
            char idx = s.charAt(i);
            if(idx==' '){
                answer += " ";
            }else if(s.charAt(i-1)==' '){
                answer += Character.toUpperCase(idx);
            }else{
                answer += Character.toLowerCase(idx);
            }
        }
        
        return answer;
    }
}