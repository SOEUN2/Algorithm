class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i=0;i<absolutes.length;i++){
            if(signs[i]){ // 참인 경우 양수
                answer += absolutes[i];
            }else{ // 거짓인 경우 음수
                answer += absolutes[i]*(-1);
            }
        }
        
        return answer;
    }
}