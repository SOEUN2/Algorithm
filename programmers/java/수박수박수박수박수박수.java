class Solution {
    public String solution(int n) {
        String answer = "";
        
        int idx = 0;
        
        while(true){
            if (idx == n){
                break;
            }
            
            if(idx%2==0){
                answer += "��";
            }else{
                answer += "��";
            }
            idx++;
        }
        
        return answer;
    }
}