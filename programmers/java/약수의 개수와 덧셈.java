class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left;i<=right;i++){
            if(divisor(i) % 2 ==0){ // 약수의 개수가 짝수인 경우
                answer += i;
            }else{ // 약수의 개수가 홀수인 경우
                answer -= i;
            }
        }
        
        return answer;
    }
    
    static int divisor(int num){
        int cnt = 0;
        for(int i=1;i<=num;i++){
            if(num%i==0){
                cnt++;
            }
        }
        return cnt;
    }
    
}