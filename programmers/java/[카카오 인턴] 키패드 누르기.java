class Solution {
    static int leftLoc = 10;
    static int rightLoc = 12;  
    public String solution(int[] numbers, String hand) {
        String answer = "";
            
        int num = 0;
        int rightDis = 0;
        int leftDis = 0;

        for(int i=0;i<numbers.length;i++){
            num = numbers[i];
            
            if(num==1 || num==4 || num==7){
                leftLoc = num;
                answer += "L";
            }else if(num==3 || num==6 || num==9){
                rightLoc = num;
                answer += "R";
            }else{
                if(num==0){ // 0을 입력한 경우 
                    num=11;
                }
                rightDis = ((Math.abs(num-rightLoc))%3) + ((Math.abs(num-rightLoc))/3);
                leftDis = ((Math.abs(num-leftLoc))%3) + ((Math.abs(num-leftLoc))/3);
                
                if(leftDis<rightDis){ // 왼손이 가까울 경우
                    leftLoc = num;
                    answer += "L";
                }else if(leftDis>rightDis){ // 오른손이 가까울 경우
                    rightLoc = num;
                    answer += "R";
                }else{ // 거리가 같을 경우
                    if(hand.equals("right")){
                        rightLoc = num;
                        answer += "R";
                    }else{
                        leftLoc = num;
                        answer += "L";
                    }
                }
            }
        }
        
        return answer;
    }
    
}