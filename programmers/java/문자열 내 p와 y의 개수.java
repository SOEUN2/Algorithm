class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] cArray = new char[s.length()];
        cArray = s.toCharArray();
        int pCnt = 0;
        int yCnt = 0;
        
        for(int i=0;i<cArray.length;i++){
            if(cArray[i]=='p' || cArray[i]=='P'){
                pCnt++;
            }else if(cArray[i]=='y'|| cArray[i]=='Y'){
                yCnt++;
            }
        }
        
        if(pCnt!=yCnt){
            answer=false;
        }
        
        return answer;
    }
}