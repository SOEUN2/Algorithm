class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        char[] temp = new char[s.length()];
        temp = s.toCharArray();
        
        for(int i=0;i<temp.length;i++){
            if(temp[i]>='a' && temp[i]<='z'){
                answer += (char)((temp[i]-'a'+n)%26+'a');
            }else if(temp[i]>='A' && temp[i]<='Z'){
                answer += (char)((temp[i]-'A'+n)%26+'A');
            }else{
                answer += temp[i];
            }
        }
        return answer;
    }
}