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

			map[start][end] = 1; // ���� ǥ��
			map[end][start] = 1; // ����� ó��
		} // for�� End
	}// input Function End

	private static void solution() throws IOException {
		boolean[] visited = new boolean[N + 1]; // �湮 ���� üũ
		dfs(V, visited);
		bw.write("\n");
		Arrays.fill(visited, false);
		bfs(V, visited);
	}// solution Function End

	private static void dfs(int point, boolean[] visited) throws IOException {
		visited[point] = true; // �湮 ó��
		bw.write(point + " ");

		for (int i = 1; i < N + 1; i++) {
			if (visited[i]) // �湮 ���� üũ
				continue;
			if (map[point][i] == 0) // ������ �Ǿ����� ���� �����̶��
				continue;

			dfs(i, visited);
		} // for�� End
	}// dfs Function End

	private static void bfs(int point, boolean[] visited) throws IOException {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.add(point);
		visited[point] = true; // �湮 üũ

		while (!dq.isEmpty()) {
			// �ش� ���� ó��
			int cur = dq.poll();
			bw.write(cur + " ");

			for (int i = 1; i < N + 1; i++) { // ���� ���� ó��
				if (visited[i]) // �湮 ���� üũ
					continue;
				if (map[cur][i] == 0) // ������ �Ǿ����� ���� �����̶��
					continue;

				dq.add(i); // ���� �湮 ���� �߰�
				visited[i] = true; // �湮 ó��
			}
		}
	}// bfs Function End

	private static void output() throws IOException {
		br.close();
		bw.flush();
		bw.close();
	}// output Function End
}// Class End