import java.lang.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        boolean[] prime = new boolean[n+1];
        int end = (int)Math.sqrt(n);
            
        for(int i=2;i<=end;i++){
            if(prime[i]){
                continue;
            }
            for(int j=2*i;j<=n;j+=i){
               prime[j] = true; 
            }
        }
        
        for(int i=2;i<=n;i++){
            if(!prime[i]){
                answer++;
            }
        }
        
        return answer;
    }    
}