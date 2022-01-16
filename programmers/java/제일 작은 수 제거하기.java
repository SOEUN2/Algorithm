import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        int[] temp = Arrays.copyOf(arr, arr.length);
        
        Arrays.sort(temp);
        
        if(arr.length==1){
            answer = new int[1];
            answer[0] = -1;
        }else{
            for(int i=0,j=0;i<arr.length;i++){
                if(arr[i]==temp[0]){
                    continue;
                }
                answer[j] = arr[i];
                j++;
            }
        }
        
        return answer;
    }
}