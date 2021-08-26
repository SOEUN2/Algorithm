import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	private static int N, M, V;
	private static int[][] map;
	private static BufferedReader br;
	private static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		input();
		solution();
		output();
	}// main Function End

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			map[start][end] = 1; // 연결 표시
			map[end][start] = 1; // 양방향 처리
		} // for문 End
	}// input Function End

	private static void solution() throws IOException {
		boolean[] visited = new boolean[N + 1]; // 방문 여부 체크
		dfs(V, visited);
		bw.write("\n");
		Arrays.fill(visited, false);
		bfs(V, visited);
	}// solution Function End

	private static void dfs(int point, boolean[] visited) throws IOException {
		visited[point] = true; // 방문 처리
		bw.write(point + " ");

		for (int i = 1; i < N + 1; i++) {
			if (visited[i]) // 방문 여부 체크
				continue;
			if (map[point][i] == 0) // 연결이 되어있지 않은 정점이라면
				continue;

			dfs(i, visited);
		} // for문 End
	}// dfs Function End

	private static void bfs(int point, boolean[] visited) throws IOException {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.add(point);
		visited[point] = true; // 방문 체크

		while (!dq.isEmpty()) {
			// 해당 정점 처리
			int cur = dq.poll();
			bw.write(cur + " ");

			for (int i = 1; i < N + 1; i++) { // 연결 정점 처리
				if (visited[i]) // 방문 여부 체크
					continue;
				if (map[cur][i] == 0) // 연결이 되어있지 않은 정점이라면
					continue;

				dq.add(i); // 다음 방문 정점 추가
				visited[i] = true; // 방문 처리
			}
		}
	}// bfs Function End

	private static void output() throws IOException {
		br.close();
		bw.flush();
		bw.close();
	}// output Function End
}// Class End