import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> number = new ArrayList<>();
        
        int q = n;
        // 3진법으로 변환
        while(true){
            if(q==0){
                break;
            }
            number.add(q % 3); // 앞뒤 반전해서 리스트에 추가
            q /= 3;
        }
        
        // 10진법으로 변환
        int temp = number.size();
        for(int i=0;i<temp;i++){
            answer += number.get(i) * Math.pow(3, temp-(i+1));
        }
        
        return answer;
    }
}