import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static final int INF = Integer.MAX_VALUE;

	static final int RUN = 0;
	static final int WALK = 1;
	static final int NOTHING = -1;

	static class Edge implements Comparable<Edge> {
		int idx;
		int w;
		int state;

		public Edge(int idx, int w) {
			this.idx = idx;
			this.w = w;
		}

		public Edge(int idx, int w, int state) {
			this.idx = idx;
			this.w = w;
			this.state = state;
		}

		@Override
		public int compareTo(Main.Edge o) {
			return Integer.compare(this.w, o.w);
		}

	}

	static int N, M;

	static int result;

	static ArrayList<Edge>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		int[] foxResult = new int[N + 1];
		int[][] tmpWolfResult = new int[N + 1][2];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()) * 2;

			graph[from].add(new Edge(to, w));
			graph[to].add(new Edge(from, w));

		}

		Arrays.fill(foxResult, INF);
		dijkstra(foxResult, NOTHING);
		for (int i = 0; i <= N; i++) {
			Arrays.fill(tmpWolfResult[i], INF);
		}

		wolfDijkstra(tmpWolfResult, RUN);

		int[] wolfResult = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			wolfResult[i] = Math.min(tmpWolfResult[i][0], tmpWolfResult[i][1]);
			if (foxResult[i] < wolfResult[i]) {
				result++;
			}
		}

		System.out.println(result);

	}

	public static void dijkstra(int[] result, int state) {
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0, state));
		result[1] = 0;

		while (!pq.isEmpty()) {

			Edge cur = pq.poll();

			if (visited[cur.idx])
				continue;

			visited[cur.idx] = true;

			for (Edge next : graph[cur.idx]) {
				int nextWeight = getWeight(cur.state, next.w);
				if (result[next.idx] > result[cur.idx] + nextWeight) {
					result[next.idx] = result[cur.idx] + nextWeight;
					pq.add(new Edge(next.idx, result[next.idx], NOTHING));
				}
			}

		}
	}

	public static void wolfDijkstra(int[][] result, int state) {
		boolean[][] visited = new boolean[N + 1][2];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0, state));
//		result[1][0] = 0;
		result[1][1] = 0;

		while (!pq.isEmpty()) {

			Edge cur = pq.poll();

			if (visited[cur.idx][cur.state])
				continue;
			visited[cur.idx][cur.state] = true;

			for (Edge next : graph[cur.idx]) {
				int nextWeight = getWeight(cur.state, next.w);
				int prevState = (cur.state == WALK) ? RUN : WALK;
				if (result[next.idx][cur.state] > result[cur.idx][prevState] + nextWeight) {
					result[next.idx][cur.state] = result[cur.idx][prevState] + nextWeight;
					if (cur.state == WALK) {
						pq.add(new Edge(next.idx, result[next.idx][cur.state], RUN));
					} else if (cur.state == RUN) {
						pq.add(new Edge(next.idx, result[next.idx][cur.state], WALK));
					}
				}
			}

		}
	}

	public static int getWeight(int state, int w) {
		if (state == NOTHING) {
			return w;
		} else if (state == RUN) {
			return w / 2;
		}
		return w * 2;
	}
}