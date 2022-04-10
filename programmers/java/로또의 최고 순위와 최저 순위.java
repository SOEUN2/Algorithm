import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCnt = 0;
        int goalCnt = 0;
        
        for(int i=0;i<lottos.length;i++){
            if(lottos[i]==0){
                zeroCnt++;                
            }else{
                for(int j=0;j<win_nums.length;j++){
                    if(lottos[i]==win_nums[j]){
                        goalCnt++;
                        break;
                    }
                }
            }
        }
        
        answer[0] = rank(goalCnt+zeroCnt);
        answer[1] = rank(goalCnt);
        
        return answer;
    }
    
    static int rank(int number){
        if(number==6){
            return 1;
        }else if(number==5){
            return 2;
        }else if(number==4){
            return 3;
        }else if(number==3){
            return 4;
        }else if(number==2){
            return 5;
        }else{
            return 6;
        }
    }
}