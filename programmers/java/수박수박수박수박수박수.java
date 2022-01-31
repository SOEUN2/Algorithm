class Solution {
    public String solution(int n) {
        String answer = "";
        
        int idx = 0;
        
        while(true){
            if (idx == n){
                break;
            }
            
            if(idx%2==0){
                answer += "¼ö";
            }else{
                answer += "¹Ú";
            }
            idx++;
        }
        
        return answer;
    }
}