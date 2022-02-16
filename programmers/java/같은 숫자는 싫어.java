import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int idx = 0;
        int idx2 = 1;
                     
        while(true){
            if(idx>=arr.length || idx2>=arr.length){
                list.add(arr[arr.length-1]);
                break;
            }
            
            if(arr[idx]==arr[idx2]){
                idx2++;
                continue;
            }
            list.add(arr[idx]);
            idx = idx2;
            idx2 = idx+1;
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}