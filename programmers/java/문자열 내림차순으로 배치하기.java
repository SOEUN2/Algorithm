import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";

        char[] cArray = new char[s.length()];
        cArray = s.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        
        for(int i=0;i<cArray.length;i++){
            list.add(cArray[i]);
        }        
        
        Collections.sort(list, Collections.reverseOrder());
        
        for(int i=0;i<list.size();i++){
            answer += list.get(i);
        }
        
        return answer;
    }
}