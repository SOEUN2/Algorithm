class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] month = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = new String[]{"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int sum = 0;
        
        for(int i=0;i<a-1;i++){
            sum += month[i];
        }
        
        sum += b-1; // 1월 1일까지 더하고 계산하기때문에 하루 덜 계산
        answer = day[sum%7];
        
        return answer;
    }
}