import java.util.*;

class Solution {
    int[] answer;
    
    public int[] solution(int[] answers) {
        int[] person1 = new int[]{1, 2, 3, 4, 5};
        int[] person2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] cnt = new int[3];
        
        int idx = 0;
        while(true){
            if(idx == answers.length){
                break;
            }
            
            if(person1[idx%5]==answers[idx]){
                cnt[0]++;
            }
            if(person2[idx%8]==answers[idx]){
                cnt[1]++;
            }
            if(person3[idx%10]==answers[idx]){
                cnt[2]++;
            }
                
            idx++;
        }
        
        int max = Math.max(Math.max(cnt[0], cnt[1]), cnt[2]);
       
        ArrayList<Integer> list = new ArrayList<>();
        if(cnt[0]==max){
            list.add(1);
        }
        if(cnt[1]==max){
            list.add(2);
        }
        if(cnt[2]==max){
            list.add(3);
        }
        
        answer = new int[list.size()];
        
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}