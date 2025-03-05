import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, K;
	static int[][] map;
	static boolean[][] visited;

	static int max = Integer.MIN_VALUE;
	static int result = Integer.MIN_VALUE;

	static int[] dirR = { -1, 1, 0, 0 };
	static int[] dirC = { 0, 0, -1, 1 };

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			result = Integer.MIN_VALUE;
			max = Integer.MIN_VALUE;

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) {
						visited[i][j] = true;
						dfs(i, j, 1, map[i][j], false);
						visited[i][j] = false;
					}
				}
			}

			sb.append("#" + tc + " ").append(result).append('\n');
		}
		System.out.println(sb);
	}

	public static void dfs(int r, int c, int dis, int height, boolean isCut) {

		result = Math.max(result, dis);

		for (int i = 0; i < 4; i++) {
			int nextR = r + dirR[i];
			int nextC = c + dirC[i];

			if (!isIn(nextR, nextC) || visited[nextR][nextC])
				continue;

			// 자른 적 있는 경우는 현재 높이보다 작을 때에만 탐색 가능
			if (isCut) {
				if (height > map[nextR][nextC]) {
					visited[nextR][nextC] = true;
					dfs(nextR, nextC, dis + 1, map[nextR][nextC], isCut);
					visited[nextR][nextC] = false;
				}
			}

			// 아직 자른 적이 없는 경우
			// 다음 경로를 보고 자를지 말지 정해서 탐색
			else {

				if (height > map[nextR][nextC]) {
					visited[nextR][nextC] = true;
					dfs(nextR, nextC, dis + 1, map[nextR][nextC], isCut);
					visited[nextR][nextC] = false;
				}

				// 자르면 갈 수 있는 경우 자르고 이동
				// 현재 위치의 높이보다 1보다 낮게 하는게 가장 최적의 방법
				else if ((map[nextR][nextC] - K) < height) {
					visited[nextR][nextC] = true;
					dfs(nextR, nextC, dis + 1, height - 1, true);
					visited[nextR][nextC] = false;
				}

			}

		}
	}

	public static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}

}
