import java.lang.Math;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int min = Math.min(n, m);
        int max = Math.max(n, m);
        
        answer[0] = gcd(max, min);
        answer[1] = n*m/answer[0];    
        return answer;
    }
    
    static int gcd(int a, int b){
        int temp = 0;
        while(true){
            if(b==0){
                break;
            }
            temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}