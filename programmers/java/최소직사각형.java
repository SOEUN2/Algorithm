class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int height = 0; // ���� �� ����
        int width = 0; // ���� �� ���� 
        
        for(int i=0;i<sizes.length;i++){            
            if(Math.max(sizes[i][0],sizes[i][1]) > height){
                height = Math.max(sizes[i][0],sizes[i][1]);
            }
            if(Math.min(sizes[i][0],sizes[i][1])>width){
                width = Math.min(sizes[i][0],sizes[i][1]);
            }
        }        
        
        answer = height * width;
                
        return answer;
    }
}