import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char[][] map;
	static boolean[][] visited;

	static int[] dirR = { -1, 0, 1 };
	static int[] dirC = { 1, 1, 1, };

	static int cnt;
	static boolean isPossible;

	public static void main(String[] args) throws Exception {
		input();
		for (int i = 0; i < R; i++) {
			isPossible = false;
			dfs(i, 0);
		}

		System.out.println(cnt);
	}

	public static void dfs(int r, int c) {
		if (c == C - 1) {
			cnt++;
			isPossible = true;
			return;
		}

		for (int d = 0; d < 3; d++) {

			int nextR = r + dirR[d];
			int nextC = c + dirC[d];

			if (!isIn(nextR, nextC) || visited[nextR][nextC] || map[nextR][nextC] == 'x')
				continue;

			visited[nextR][nextC] = true;
			dfs(nextR, nextC);
			if (isPossible) {
				return;
			}
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

		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			map[i] = line.toCharArray();

		}

	}
}