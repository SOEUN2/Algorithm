class Solution {
    public int[] solution(long n) {
        
        String num = Long.toString(n);
        
        int[] answer = new int[num.length()];
        int idx = 0;
        
        while(true){
            if(n<=0){
                break;
            }
            answer[idx++] = (int)(n % 10);
            n/=10;
        }
        
        return answer;
    }
}