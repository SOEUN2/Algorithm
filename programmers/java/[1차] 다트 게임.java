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
            
            char dartChar = dartResult.charAt(idx); // ���� ó��
            int dartInt = dartChar-'0'; // ���� ó��
            
                
			if (0 <=  dartInt && dartInt <= 10) { // ������ ���
                if(dartInt == 1){ // ���ڸ��� 1�� ��� 1���� 10���� Ȯ��
                    if(dartResult.charAt(idx+1)-'0' == 0){ // 10�� ���
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