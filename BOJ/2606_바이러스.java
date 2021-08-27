import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br;
	private static int[][] map;
	private static int computer, answer;

	public static void main(String[] args) throws IOException {
		input();
		solution();
		output();
	}// main Function End

	private static void input() throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		computer = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		int connect = Integer.parseInt(br.readLine()); // 연결된 네트워크 수
		map = new int[computer + 1][computer + 1]; // 컴퓨터 연결 상태
		for (int i = 1; i < connect + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][to] = 1; // 두 정점연결 상태 처리
			map[to][from] = 1; // 양방향 처리
		} // for Function End
	}// input Function End

	private static void solution() {

		/*
		 * BFS 처리
		 */
		Deque<Integer> dq = new ArrayDeque<>(); // 바이러스 감염 컴퓨터 관리 덱
		boolean[] visited = new boolean[computer + 1]; // 방문 처리 배열
		dq.add(1); // 1번 컴퓨터 감염
		visited[1] = true; // 1번 컴퓨터 방문 처리

		while (!dq.isEmpty()) {
			int cur = dq.poll(); // 감염시킬 컴퓨터

			for (int i = 1; i < computer + 1; i++) { // 연결된 컴퓨터 처리
				if (visited[i]) // 방문 여부 체크
					continue;
				if (map[cur][i] == 0) // 연결되어있지 않은 컴퓨터라면
					continue;

				dq.add(i); // 다음에 감염처리할 컴퓨터에 추가
				visited[i] = true; // 다음 감염 컴퓨터 방문 처리
				answer++; // 감염 컴퓨터 추가
			} // for문 End
		} // while문 End

	}// solution Function End

	private static void output() throws IOException {
		br.close();
		System.out.println(answer);
	}// output Function End
}// Class End