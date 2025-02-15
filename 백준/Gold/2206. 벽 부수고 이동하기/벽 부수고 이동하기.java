import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static int[][] map;
	static boolean[][][] visited;

	static int[] dirR = { -1, 1, 0, 0 };
	static int[] dirC = { 0, 0, -1, 1 };

	static boolean exitFlag;

	public static void main(String[] args) throws IOException {
		input();
		bfs();
		if (!exitFlag) {
			System.out.println("-1");
		}
	}

	public static void bfs() {

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 1, false));
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.r == R - 1 && cur.c == C - 1) {
				System.out.println(cur.dis);
				exitFlag = true;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nextR = cur.r + dirR[i];
				int nextC = cur.c + dirC[i];

				if (!cur.isPunch) {
					if (isIn(nextR, nextC) && !visited[nextR][nextC][1] && map[nextR][nextC] == 1) {
						visited[nextR][nextC][1] = true;
						q.add(new Node(nextR, nextC, cur.dis + 1, true));
					} else if (isIn(nextR, nextC) && !visited[nextR][nextC][0] && map[nextR][nextC] == 0) {
						visited[nextR][nextC][0] = true;
						q.add(new Node(nextR, nextC, cur.dis + 1, cur.isPunch));
					}
				}

				else {
					if (isIn(nextR, nextC) && !visited[nextR][nextC][1] && map[nextR][nextC] == 0) {
						visited[nextR][nextC][1] = true;
						q.add(new Node(nextR, nextC, cur.dis + 1, cur.isPunch));
					}
				}

			}

		}

	}

	public static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		visited = new boolean[R][C][2];
		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = (int) (tmp.charAt(j) - '0');
			}
		}

	}
}

class Node {
	int r;
	int c;
	int dis;
	boolean isPunch;

	public Node(int r, int c, int dis, boolean isPunch) {
		this.r = r;
		this.c = c;
		this.dis = dis;
		this.isPunch = isPunch;
	}
}