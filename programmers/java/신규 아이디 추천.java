class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        String level1 = new_id.toLowerCase();
        
        String level2 = "";
        for(int i=0;i<level1.length();i++){
            char temp = level1.charAt(i);
            if((temp>='a' && temp<='z')||(temp>='0' && temp<='9')||temp=='-'||temp=='_'||temp=='.'){
                level2 += temp;
            }
        }
        
        String level3 = level2;
        while(level3.contains("..")){
            level3 = level3.replace("..", ".");
        }
        
        String level4 = level3;
        if(level4.length()>0){
            if(level4.charAt(0)=='.'){
                level4 = level4.substring(1, level4.length());
            }
        }
        if(level4.length()>0){
            if(level4.charAt(level4.length()-1)=='.'){
                level4 = level4.substring(0, level4.length()-1);
            }
        }
        
        String level5 = level4;
        if(level5.length()==0){
            level5 = "a";
        }
        
        String level6 = level5;
        if(level6.length()>15){
            level6 = level6.substring(0, 15);
        }
        if(level6.charAt(level6.length()-1)=='.'){
                level6 = level6.substring(0, level6.length()-1);
        }
        
        String level7 = level6;
        if(level7.length()<=2){
            for(int i=level7.length();i<3;i++){
                level7 += level7.charAt(level7.length()-1);
            }
        }
        
        answer = level7;
        return answer;
    }
}