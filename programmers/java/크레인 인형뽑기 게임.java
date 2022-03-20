import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<moves.length;i++){ // 전체 크레인을 작동시키는 만큼 처리
            for(int j=0;j<board.length;j++){ // 세로 길이만큼 탐색하면서 인형을 찾음
                if(board[j][moves[i]-1]!=0){ // 뽑아야할 인형이 있는 경우
                    if(stack.size()==0){ // 인형을 처음 뽑은 경우
                        stack.add(board[j][moves[i]-1]);
                    }else{ // 기존에 인형이 있는 경우
                        int doll = stack.pop();
                        if(doll!=board[j][moves[i]-1]){ // 인형이 같지 않다면 다시 두 개 다 넣어준다.
                            stack.add(doll);
                            stack.add(board[j][moves[i]-1]);
                        }else{
                            answer += 2;
                        }
                    }
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
}