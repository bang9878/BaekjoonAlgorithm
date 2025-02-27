import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Main {

	static int L, R, C;
	static char[][][] building;

	static int startL, startR, startC;

	static int[] dirL = { 0, 0, 0, 0, 1, -1 };
	static int[] dirR = { -1, 1, 0, 0, 0, 0 };
	static int[] dirC = { 0, 0, -1, 1, 0, 0 };

	static boolean isExit;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while (true) {
			
			st = new StringTokenizer(br.readLine());
			
			L = parseInt(st.nextToken());
			R = parseInt(st.nextToken());
			C = parseInt(st.nextToken());

			if (L == 0 && R == 0 && C == 0)
				break;

			building = new char[L][R][C];
			for (int h = 0; h < L; h++) {
				for (int i = 0; i < R; i++) {
					String line = br.readLine();
					for (int j = 0; j < C; j++) {
						if (line.charAt(j) == 'S') {
							startL = h;
							startR = i;
							startC = j;
						}
						building[h][i][j] = line.charAt(j);
					}
				}
				br.readLine();
			}

			isExit = false;
			bfs();
			if (isExit) {
				sb.append(String.format("Escaped in %d minute(s).", result)).append('\n');
			} else {
				sb.append("Trapped!").append('\n');
			}

		}
		
		System.out.println(sb);

	}

	public static void bfs() {

		boolean[][][] visited = new boolean[L][R][C];

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(startL, startR, startC, 0));
		visited[startL][startR][startC] = true;

		while (!q.isEmpty()) {

			Node cur = q.poll();

			if (building[cur.l][cur.r][cur.c] == 'E') {
				isExit = true;
				result = cur.min;
				return;
			}

			for (int i = 0; i < 6; i++) {
				int nextL = cur.l + dirL[i];
				int nextR = cur.r + dirR[i];
				int nextC = cur.c + dirC[i];

				if (!isIn(nextL, nextR, nextC) || visited[nextL][nextR][nextC] ||
						building[nextL][nextR][nextC] == '#')
					continue;

				visited[nextL][nextR][nextC] = true;
				q.add(new Node(nextL, nextR, nextC, cur.min + 1));
			}
		}
	}

	public static boolean isIn(int l, int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C && 0 <= l && l < L;
	}
}

class Node {
	int l;
	int r;
	int c;
	int min;

	public Node(int l, int r, int c, int min) {
		this.l = l;
		this.r = r;
		this.c = c;
		this.min = min;
	}
}