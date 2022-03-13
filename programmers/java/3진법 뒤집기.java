import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> number = new ArrayList<>();
        
        int q = n;
        // 3�������� ��ȯ
        while(true){
            if(q==0){
                break;
            }
            number.add(q % 3); // �յ� �����ؼ� ����Ʈ�� �߰�
            q /= 3;
        }
        
        // 10�������� ��ȯ
        int temp = number.size();
        for(int i=0;i<temp;i++){
            answer += number.get(i) * Math.pow(3, temp-(i+1));
        }
        
        return answer;
    }
}