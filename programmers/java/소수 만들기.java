import java.util.*;

class Solution {
    static int answer;
    static int[] pick;
    
    public int solution(int[] nums) {
        answer = 0;
        pick = new int[3];

        combination(0, 0, nums);

        return answer;
    }
    
    static void combination(int cnt, int start, int[] nums){
        if (cnt == 3){
            int num = 0;
            for(int i=0;i<pick.length;i++){
                num += pick[i];
            }
            checkPrime(num);
            return;
        }
        for(int i=start; i<nums.length;i++){
            pick[cnt] = nums[i];
            combination(cnt+1, i+1, nums);
        }
    }
    
    static void checkPrime(int num){
        for(int i=2;i<num;i++){
            if(num%i==0){
                return;
            }
        }
        answer++;
    }
    
}