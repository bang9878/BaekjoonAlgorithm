import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] map;

	static int[] dirR = { -1, 1, 0, 0 };
	static int[] dirC = { 0, 0, -1, 1 };

	static int[][] landNumArr;
	static int landCnt = 1;
	static boolean[][] visited;

	static int[] selectLandArr = new int[2];

	public static void main(String[] args) throws Exception {
		input();
		// 각각의 섬들을 찾아서 표시
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					landBfs(i, j);
					landCnt++;
				}
			}
		}

		searchLand();

	}

	public static void searchLand() {
		boolean[][][] visited = new boolean[N][N][landCnt];

		Queue<Land> q = new LinkedList<Land>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && isOutLine(i, j)) {
					q.add(new Land(i, j, landNumArr[i][j], 0));
				}
			}
		}

		while (!q.isEmpty()) {

			Land cur = q.poll();

			if (landNumArr[cur.r][cur.c] != 0 && (landNumArr[cur.r][cur.c] != cur.landNum)) {
				System.out.println(cur.dis - 1);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dirR[d];
				int nc = cur.c + dirC[d];

				if (!isIn(nr, nc) || visited[nr][nc][cur.landNum] || cur.landNum == landNumArr[nr][nc])
					continue;

				visited[nr][nc][cur.landNum] = true;
				q.add(new Land(nr, nc, cur.landNum, cur.dis + 1));

			}
		}

	}

	public static void landBfs(int r, int c) {

		Queue<Node> q = new LinkedList<>();

		landNumArr[r][c] = landCnt;
		visited[r][c] = true;
		q.add(new Node(r, c));

		while (!q.isEmpty()) {

			Node cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dirR[d];
				int nc = cur.c + dirC[d];

				if (!isIn(nr, nc) || visited[nr][nc] || map[nr][nc] == 0)
					continue;

				visited[nr][nc] = true;
				q.add(new Node(nr, nc));
				landNumArr[nr][nc] = landCnt;
			}
		}
	}

	public static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}

	public static boolean isOutLine(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dirR[d];
			int nc = c + dirC[d];

			if (isIn(nr, nc) && map[nr][nc] == 0) {
				return true;
			}

		}
		return false;
	}

	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		landNumArr = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}

class Land {
	int r;
	int c;
	int landNum;
	int dis;

	public Land(int r, int c, int landNum, int dis) {
		this.r = r;
		this.c = c;
		this.landNum = landNum;
		this.dis = dis;
	}
}

class Node {
	int r;
	int c;

	public Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}