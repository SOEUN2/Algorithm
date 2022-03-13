import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N]; 
        int[] clear = new int[N+2];
        
        int passPlayer = stages.length; // 스테이지에 도달한 플레이어 수(변동)
        
        for(int i=0;i<stages.length;i++){
            clear[stages[i]]++;
        }
        
        ArrayList<Fail> list = new ArrayList<>();
        for(int i=1;i<clear.length-1;i++){
            passPlayer-=clear[i-1];
            double rate = (double)clear[i]/passPlayer;
            if(passPlayer==0){ // 스테이지에 도달한 유저가 없는 경우
                list.add(new Fail(i, 0));
                continue;
            }
            list.add(new Fail(i, rate));
        }
        
        Collections.sort(list, new Comparator<Fail>(){
            @Override
            public int compare(Fail f1, Fail f2){
                if(f1.failRate == f2.failRate){
                    return f1.stageNum - f2.stageNum;
                }
                
                return Double.compare(f2.failRate, f1.failRate);
            }
        });
        
        for(int i=0;i<list.size();i++){
             answer[i] = list.get(i).stageNum;
        }
        
        return answer;
    }
    
    class Fail{
        int stageNum;
        double failRate;
        
        Fail(int stageNum, double failRate){
            this.stageNum = stageNum;
            this.failRate = failRate;
        }
    }
}