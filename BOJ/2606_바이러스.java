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

		computer = Integer.parseInt(br.readLine()); // ��ǻ���� ��
		int connect = Integer.parseInt(br.readLine()); // ����� ��Ʈ��ũ ��
		map = new int[computer + 1][computer + 1]; // ��ǻ�� ���� ����
		for (int i = 1; i < connect + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][to] = 1; // �� �������� ���� ó��
			map[to][from] = 1; // ����� ó��
		} // for Function End
	}// input Function End

	private static void solution() {

		/*
		 * BFS ó��
		 */
		Deque<Integer> dq = new ArrayDeque<>(); // ���̷��� ���� ��ǻ�� ���� ��
		boolean[] visited = new boolean[computer + 1]; // �湮 ó�� �迭
		dq.add(1); // 1�� ��ǻ�� ����
		visited[1] = true; // 1�� ��ǻ�� �湮 ó��

		while (!dq.isEmpty()) {
			int cur = dq.poll(); // ������ų ��ǻ��

			for (int i = 1; i < computer + 1; i++) { // ����� ��ǻ�� ó��
				if (visited[i]) // �湮 ���� üũ
					continue;
				if (map[cur][i] == 0) // ����Ǿ����� ���� ��ǻ�Ͷ��
					continue;

				dq.add(i); // ������ ����ó���� ��ǻ�Ϳ� �߰�
				visited[i] = true; // ���� ���� ��ǻ�� �湮 ó��
				answer++; // ���� ��ǻ�� �߰�
			} // for�� End
		} // while�� End

	}// solution Function End

	private static void output() throws IOException {
		br.close();
		System.out.println(answer);
	}// output Function End
}// Class End