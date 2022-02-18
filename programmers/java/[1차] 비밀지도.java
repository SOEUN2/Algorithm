class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0;i<n;i++){
            String map1 = Integer.toBinaryString(arr1[i]);
            String map2 = Integer.toBinaryString(arr2[i]);
            
            String newMap1 = makeEqual(n, map1);
            String newMap2 = makeEqual(n, map2);
            
            String tempAnswer = "";
            for(int j=0;j<n;j++){
                if(newMap1.charAt(j)=='0' && newMap2.charAt(j)=='0'){ // 공백
                    tempAnswer += " ";
                }else{ // 벽
                    tempAnswer += "#";
                }
            }
            answer[i] = tempAnswer;
        }
        return answer;
    }
    
    // 자리 수를 맞춰주는 함수
    static String makeEqual(int n, String map){
        String temp = "";
        
        for(int i=0;i<n-map.length();i++){
            temp += "0";
        }
        temp += map;
        
        return temp;
    }
}