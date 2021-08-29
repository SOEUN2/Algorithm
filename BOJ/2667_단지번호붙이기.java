import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

	private static char[][] map; // ����
	private static int[] aptCnt; // ������ ���� ��
	private static int N, aptComplex; // ������ ũ��, ����Ʈ ����
	private static boolean[][] visited; // �湮üũ
	private static int[] dr = { -1, 1, 0, 0 }; // �����¿�
	private static int[] dc = { 0, 0, -1, 1 }; // �����¿�

	public static void main(String[] args) throws Exception {
		input();
		solution();
		output();
	}// main Function End

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		aptCnt = new int[N * N];

		for (int i = 0; i < map.length; i++) {
			map[i] = br.readLine().toCharArray();
		}
	}// input Function End

	private static void solution() {
		// ���� N*N Ž��
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == '0') // ���� ���� ���
					continue;
				if (visited[i][j]) // �̹� �湮�� ���
					continue;
				aptComplex++; // ���� üũ�� ����Ʈ ����
				bfs(i, j);
			}
		} // ����for�� End
	}// solution Function End

	private static void bfs(int x, int y) {
		Deque<Point> dq = new ArrayDeque<>();
		dq.add(new Point(x, y));
		visited[x][y] = true; // �ش� ��ǥ �湮ó��
		aptCnt[aptComplex]++; // �ش� ������ ����Ʈ �� ������Ŵ

		while (!dq.isEmpty()) {
			Point cur = dq.poll();

			for (int d = 0; d < 4; d++) { // ���� �����¿� Ž��
				int nx = cur.x + dr[d];
				int ny = cur.y + dc[d];

				if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) // ���� ������ �Ѿ�� ���
					continue;
				if (map[nx][ny] == '0') // ���� ���� ���
					continue;
				if (visited[nx][ny]) // �̹� �湮�� ���
					continue;

				dq.add(new Point(nx, ny));
				visited[nx][ny] = true;
				aptCnt[aptComplex]++;
			} // for�� End
		} // while�� End
	}// bfs Function End

	private static void output() {
		System.out.println(aptComplex);
		Arrays.sort(aptCnt);
		for (int i = 0; i < aptCnt.length; i++) {
			if (aptCnt[i] == 0)
				continue;
			System.out.println(aptCnt[i]);
		} // for�� End
	}// output Function End

	static class Point { // ��ǥ���� Ŭ����
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}// Point Class End
}// Class End