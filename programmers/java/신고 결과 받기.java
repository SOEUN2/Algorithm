import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        StringTokenizer st;
        
        Map<String, Set<String>> reportMap = new HashMap<>(); // 신고한 유저 관리 - (신고한 유저, 신고한 유저들)
        Map<String, Integer> reportedMap= new HashMap<>(); // 신고당한 유저 관리 - (신고당한 유저, 신고당한 횟수)
        
        for(int i=0;i<id_list.length;i++){
            reportMap.put(id_list[i], new HashSet<>());
            reportedMap.put(id_list[i], 0);
        }
        
        for(int i=0;i<report.length;i++){
            st = new StringTokenizer(report[i]);
            String from = st.nextToken(); // 신고한 사람
            String to = st.nextToken(); // 신고당한 사람
            if(reportMap.get(from).add(to)){ // add는 리턴타입이 true || false
                reportedMap.put(to, reportedMap.get(to)+1);
            }
        }
        
        // 신고당한 횟수가 k회 이상인 경우만 체크
       for(int i=0;i<report.length;i++){
        	st = new StringTokenizer(report[i]);
            String from = st.nextToken(); // 신고한 사람
            String to = st.nextToken(); // 신고당한 사람
            if(reportedMap.get(to) < k) {
            	reportMap.get(from).remove(to);
            }
        }
        
        for(int i=0;i<id_list.length;i++) {
        	answer[i] = reportMap.get(id_list[i]).size();
        }
        
        return answer;
    }
}