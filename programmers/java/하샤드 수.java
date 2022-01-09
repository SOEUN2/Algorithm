class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int q = x, sum = 0;
        
        while(true){
            if(q<1){
                if(x%sum!=0)
                    answer = false;
                break;
            }
            sum += q % 10;
            q /= 10;
        }
        
        return answer;
    }
}