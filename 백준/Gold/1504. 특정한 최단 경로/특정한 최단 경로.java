import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, E;
	static int v1, v2;
	static ArrayList<Node>[] list;

	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		input();

		int dist1 = dijkstra(1, v1);
		int dist2 = dijkstra(v1, v2);
		int dist3 = dijkstra(v2, N);

		int result1 = dist1 + dist2 + dist3;

		int dist4 = dijkstra(1, v2);
		int dist5 = dijkstra(v2, v1);
		int dist6 = dijkstra(v1, N);
		int result2 = dist4 + dist5 + dist6;

		if ((dist1 == INF || dist2 == INF || dist3 == INF)
				&& (dist4 == INF || dist5 == INF || dist6 == INF)) {
			System.out.println("-1");
			return;
		}

		System.out.println(Math.min(result1, result2));

	}

	public static int dijkstra(int start, int end) {

		boolean[] visited = new boolean[N + 1];
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {

			Node cur = pq.poll();

			if (visited[cur.idx])
				continue;

			visited[cur.idx] = true;

			for (Node next : list[cur.idx]) {
				if (dist[next.idx] > dist[cur.idx] + next.cost) {
					dist[next.idx] = dist[cur.idx] + next.cost;
					pq.add(new Node(next.idx, dist[next.idx]));
				}
			}

		}

		return dist[end];

	}

	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine());

		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

	}
}

class Node implements Comparable<Node> {
	int idx;
	int cost;

	public Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.cost, o.cost);
	}
}