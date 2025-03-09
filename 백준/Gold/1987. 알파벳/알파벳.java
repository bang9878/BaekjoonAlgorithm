import java.io.*;
import java.util.*;

public class Main {

	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static boolean[] isAlpha;

	static int[] dirR = { -1, 1, 0, 0 };
	static int[] dirC = { 0, 0, -1, 1 };

	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		input();
		// r, c, cnt
		visited[0][0] = true;
		isAlpha[map[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		System.out.println(max);
	}

	public static void dfs(int r, int c, int cnt) {

		max = Math.max(max, cnt);

		for (int d = 0; d < 4; d++) {
			int nr = r + dirR[d];
			int nc = c + dirC[d];

			if (!isIn(nr, nc) || visited[nr][nc] || isAlpha[map[nr][nc] - 'A'])
				continue;

			isAlpha[map[nr][nc] - 'A'] = true;
			visited[nr][nc] = true;
			dfs(nr, nc, cnt + 1);
			isAlpha[map[nr][nc] - 'A'] = false;
			visited[nr][nc] = false;

		}

	}

	public static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		isAlpha = new boolean[26];
		visited = new boolean[R][C];
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

	}
}
