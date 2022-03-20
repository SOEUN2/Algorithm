import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<moves.length;i++){ // ��ü ũ������ �۵���Ű�� ��ŭ ó��
            for(int j=0;j<board.length;j++){ // ���� ���̸�ŭ Ž���ϸ鼭 ������ ã��
                if(board[j][moves[i]-1]!=0){ // �̾ƾ��� ������ �ִ� ���
                    if(stack.size()==0){ // ������ ó�� ���� ���
                        stack.add(board[j][moves[i]-1]);
                    }else{ // ������ ������ �ִ� ���
                        int doll = stack.pop();
                        if(doll!=board[j][moves[i]-1]){ // ������ ���� �ʴٸ� �ٽ� �� �� �� �־��ش�.
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