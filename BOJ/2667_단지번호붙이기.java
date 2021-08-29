import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

	private static char[][] map; // 지도
	private static int[] aptCnt; // 단지별 집의 수
	private static int N, aptComplex; // 지도의 크기, 아파트 단지
	private static boolean[][] visited; // 방문체크
	private static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	private static int[] dc = { 0, 0, -1, 1 }; // 상하좌우

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
		// 지도 N*N 탐색
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == '0') // 집이 없는 경우
					continue;
				if (visited[i][j]) // 이미 방문한 경우
					continue;
				aptComplex++; // 현재 체크할 아파트 단지
				bfs(i, j);
			}
		} // 이중for문 End
	}// solution Function End

	private static void bfs(int x, int y) {
		Deque<Point> dq = new ArrayDeque<>();
		dq.add(new Point(x, y));
		visited[x][y] = true; // 해당 좌표 방문처리
		aptCnt[aptComplex]++; // 해당 단지의 아파트 수 증가시킴

		while (!dq.isEmpty()) {
			Point cur = dq.poll();

			for (int d = 0; d < 4; d++) { // 인접 상하좌우 탐색
				int nx = cur.x + dr[d];
				int ny = cur.y + dc[d];

				if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) // 지도 범위를 넘어가는 경우
					continue;
				if (map[nx][ny] == '0') // 집이 없는 경우
					continue;
				if (visited[nx][ny]) // 이미 방문한 경우
					continue;

				dq.add(new Point(nx, ny));
				visited[nx][ny] = true;
				aptCnt[aptComplex]++;
			} // for문 End
		} // while문 End
	}// bfs Function End

	private static void output() {
		System.out.println(aptComplex);
		Arrays.sort(aptCnt);
		for (int i = 0; i < aptCnt.length; i++) {
			if (aptCnt[i] == 0)
				continue;
			System.out.println(aptCnt[i]);
		} // for문 End
	}// output Function End

	static class Point { // 좌표관리 클래스
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}// Point Class End
}// Class End