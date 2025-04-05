import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, H;
	static int[][] map;

	static int ans;
	static boolean isAns;

	public static void main(String[] args) throws Exception {
		input();
		for (int i = 0; i <= 3; i++) {
			ans = i;
			dfs(1, 0);
			if (isAns)
				break;
		}

		System.out.println((isAns) ? ans : -1);

	}

	public static void dfs(int r, int depth) {
		if (isAns) {
			return;
		}

		if (depth == ans) {
			if (isValid()) {
				isAns = true;
			}
			return;
		}

		for (int i = r; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (map[i][j] == 0 && map[i][j + 1] == 0) {

					map[i][j] = 1;
					map[i][j + 1] = 2;

					dfs(i, depth + 1);

					map[i][j] = 0;
					map[i][j + 1] = 0;

				}
			}
		}

	}

	public static boolean isValid() {

		for (int i = 1; i <= N; i++) {

			int nc = i;
			int nr = 1;

			while (nr <= H) {
				if (map[nr][nc] == 1)
					nc++;
				else if (map[nr][nc] == 2)
					nc--;

				nr++;
			}

			if (nc != i)
				return false;

		}

		return true;

	}

	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H + 1][N + 1];

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a][b] = 1;
			map[a][b + 1] = 2;
		}

	}
}
