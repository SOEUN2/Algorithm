class Solution {
    
    public int solution(String dartResult) {
       int answer = 0;
		int idx = 0;
		int point = 0;
		int[] score = new int[3];

		while (true) {
			if (idx == dartResult.length()) {
				break;
			}
            
            char dartChar = dartResult.charAt(idx); // 글자 처리
            int dartInt = dartChar-'0'; // 숫자 처리
            
                
			if (0 <=  dartInt && dartInt <= 10) { // 점수일 경우
                if(dartInt == 1){ // 앞자리가 1인 경우 1인지 10인지 확인
                    if(dartResult.charAt(idx+1)-'0' == 0){ // 10인 경우
                        dartInt = 10;
                        idx++;
                    }
                }
				score[point] = dartInt;
				
			}else {
				if (dartChar == 'S') {
					score[point] = (int) Math.pow(score[point], 1);
					point++;
				} else if (dartChar == 'D') {
					score[point] = (int) Math.pow(score[point], 2);
					point++;
				} else if (dartChar == 'T') {
					score[point] = (int) Math.pow(score[point], 3);
					point++;
				} else if (dartChar == '*') {
					if(point-2>=0){
                        score[point-2] *=2;
                    }
                    score[point-1] *= 2;
				} else {
					score[point-1] *= -1;
				}
			}
            idx++;
		}

		for (int i = 0; i < score.length; i++) {
			answer += score[i];
		}
        
        return answer;
    }
}