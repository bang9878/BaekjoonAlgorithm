import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static int[][] map;
	static Node[] line;
	static Node[] choice = new Node[3];

	static int[] dirR = { -1, 1, 0, 0 };
	static int[] dirC = { 0, 0, -1, 1 };

	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		line = new Node[R * C];
		int idx = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				line[idx++] = new Node(i, j);
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);
		System.out.println(ans);
	}

	public static void dfs(int depth, int start) {

		if (depth == 3) {
			ans = Math.max(ans, bfs());
			return;
		}

		for (int i = start; i < R * C; i++) {
			if (map[line[i].r][line[i].c] == 0) {
				map[line[i].r][line[i].c] = 1;
				choice[depth] = new Node(line[i].r, line[i].c);
				dfs(depth + 1, start + 1);
				map[line[i].r][line[i].c] = 0;
			}
		}
	}

	public static int bfs() {

		boolean[][] visited = new boolean[R][C];
		Queue<Node> q = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 2) {
					visited[i][j] = true;
					q.offer(new Node(i, j));
				}
			}
		}

		while (!q.isEmpty()) {

			Node cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dirR[d];
				int nc = cur.c + dirC[d];

				if (!isIn(nr, nc) || visited[nr][nc] || map[nr][nc] == 1)
					continue;

				visited[nr][nc] = true;
				q.offer(new Node(nr, nc));

			}
		}

		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && map[i][j] == 0) {
					result++;
				}
			}
		}

		return result;

	}

	public static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

}

class Node {
	int r;
	int c;

	public Node(int r, int c) {
		this.r = r;
		this.c = c;
	}

	@Override
	public String toString() {
		return "Node [r=" + r + ", c=" + c + "]";
	}

}
