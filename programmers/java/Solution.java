class Solution {
    public int solution(int n) {
        int answer = 0;  
        
        int fibo[] = new int[n+1];
        
        for(int i=0;i<n+1;i++){
            if(i==0){
                fibo[i] = 0;
            }else if(i==1){
                fibo[i] = 1;
            }else{
                fibo[i] = (fibo[i-1]+fibo[i-2])%1234567;
            }
        }
        
        answer = fibo[n];
        return answer;
    }
}