import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] visited;

	static int[] dirR = { -1, 1, 0, 0 };
	static int[] dirC = { 0, 0, -1, 1 };

	
	static int idx = 1;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		
		while (true) {
			N = Integer.parseInt(br.readLine());

			if (N == 0) {
				System.out.println(sb);
				return;
			}

			map = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			solution();
			idx++;
		}
	}

	public static void solution() {
		PriorityQueue<Node> q = new PriorityQueue<>();

		q.add(new Node(0, 0, map[0][0]));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.r == N - 1 && cur.c == N - 1) {
				sb.append("Problem ").append(idx + ": ").append(cur.roopy).append('\n');
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nextR = cur.r + dirR[i];
				int nextC = cur.c + dirC[i];

				if (isIn(nextR, nextC) && !visited[nextR][nextC]) {
					int nextRoopy = cur.roopy + map[nextR][nextC];
					visited[nextR][nextC] = true;
					q.add(new Node(nextR, nextC, nextRoopy));
				}

			}
		}

	}

	public static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
}

class Node implements Comparable<Node> {
	int r;
	int c;
	int roopy;

	public Node(int r, int c, int roopy) {
		this.r = r;
		this.c = c;
		this.roopy = roopy;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.roopy, o.roopy);
	}

}
