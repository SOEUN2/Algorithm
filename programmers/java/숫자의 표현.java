class Solution {
    public int solution(int n) {
        int answer = 1; // 자기 자신 포함하고 시작
        
        for(int i=1;i<n;i++){
            int hap = 0;
            for(int j=i;j<n;j++){
                hap += j;
                if(hap == n){
                    answer++;
                    break;
                }else if(hap>n){
                    break;
                }
            }
        }
        
        return answer;
    }
}