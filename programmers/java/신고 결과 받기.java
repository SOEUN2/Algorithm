import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        StringTokenizer st;
        
        Map<String, Set<String>> reportMap = new HashMap<>(); // �Ű��� ���� ���� - (�Ű��� ����, �Ű��� ������)
        Map<String, Integer> reportedMap= new HashMap<>(); // �Ű���� ���� ���� - (�Ű���� ����, �Ű���� Ƚ��)
        
        for(int i=0;i<id_list.length;i++){
            reportMap.put(id_list[i], new HashSet<>());
            reportedMap.put(id_list[i], 0);
        }
        
        for(int i=0;i<report.length;i++){
            st = new StringTokenizer(report[i]);
            String from = st.nextToken(); // �Ű��� ���
            String to = st.nextToken(); // �Ű���� ���
            if(reportMap.get(from).add(to)){ // add�� ����Ÿ���� true || false
                reportedMap.put(to, reportedMap.get(to)+1);
            }
        }
        
        // �Ű���� Ƚ���� kȸ �̻��� ��츸 üũ
       for(int i=0;i<report.length;i++){
        	st = new StringTokenizer(report[i]);
            String from = st.nextToken(); // �Ű��� ���
            String to = st.nextToken(); // �Ű���� ���
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