import java.io.*;
import java.util.*;

public class Main {

	static int R, C, T;
	static int[][] map;
	static boolean[][][] visited;

	static int[] dirR = { -1, 1, 0, 0 };
	static int[] dirC = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		input();
		bfs();
	}

	public static void bfs() {

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 0, 0));
		visited[0][0][0] = true;

		while (!q.isEmpty()) {

			Node cur = q.poll();

			if (map[cur.r][cur.c] == 2) {
				cur.weapon = 1;
			}
			
			if(cur.t > T) break;

			if (cur.r == (R - 1) && cur.c == (C - 1)) {
				System.out.println(cur.t);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dirR[d];
				int nc = cur.c + dirC[d];

				if (!isIn(nr, nc) || visited[nr][nc][cur.weapon])
					continue;

				visited[nr][nc][cur.weapon] = true;

				if (cur.weapon == 1) {
					q.add(new Node(nr, nc, cur.t + 1, cur.weapon));
				} else if (map[nr][nc] != 1 && cur.weapon == 0) {
					q.add(new Node(nr, nc, cur.t + 1, cur.weapon));
				}

			}
		}
		System.out.println("Fail");
	}

	public static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		visited = new boolean[R][C][2];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}

class Node {
	int r;
	int c;
	int t;
	int weapon;

	public Node(int r, int c, int t, int weapon) {
		this.r = r;
		this.c = c;
		this.t = t;
		this.weapon = weapon;
	}

}