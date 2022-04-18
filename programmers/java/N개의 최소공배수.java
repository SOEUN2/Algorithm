class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i=1;i<arr.length;i++){
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }
    
    // 최소공배수
    static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }
    
    // 최대공약수
    static int gcd(int a, int b){
        while(true){
            if(b==0){
                break;
            }
            int r=a%b;
            a=b;
            b=r;
        }
        return a;
    }    
}