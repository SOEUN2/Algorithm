import java.util.*;

class Solution {
    
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i=0;i<lost.length;i++){
            checkStil(i, lost, reserve);
        }
        
        for(int i=0;i<lost.length;i++){
            find(i, lost, reserve);
        }
        
        int lostStudent = 0;
        for(int i=0;i<lost.length;i++){
            if(lost[i]==-1){
                continue;
            }
            lostStudent++;
        }
        answer = n-lostStudent;
        return answer;
    }
    static void checkStil(int idx, int[] lost, int[] reserve){
        for(int i=0;i<reserve.length;i++){
            if(lost[idx]==reserve[i]){
                lost[idx] = -1;
                reserve[i] = -1;
            }
        }
    }
    
    static void find(int idx, int[] lost, int[] reserve){
        for(int i=0;i<reserve.length;i++){
            if(Math.abs(lost[idx]-reserve[i])==1){
                lost[idx] = -1;
                reserve[i] = -1;
                return;
            }
        }
    }
    
}