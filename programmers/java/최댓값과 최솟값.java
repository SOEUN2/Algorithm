import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s);
        
        int cnt = st.countTokens();
        int min = Integer.parseInt(st.nextToken());
        int max = min;
        
        for(int i=1;i<cnt;i++){
            int idx = Integer.parseInt(st.nextToken());
            min = Math.min(min, idx);
            max = Math.max(max, idx);
        }
        
        answer += min + " " + max;
        return answer;
    }
}