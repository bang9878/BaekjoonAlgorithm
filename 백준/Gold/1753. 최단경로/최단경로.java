import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static ArrayList<Node>[] list;

	static int start;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		input();
		dijkstra();
		output();
	}

	public static void dijkstra() {

		boolean[] visited = new boolean[V + 1];
		dist = new int[V + 1];
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
	}

	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		start = Integer.parseInt(br.readLine());
		list = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list[u].add(new Node(v, w));
		}

//		for(int i = 1; i <= V; i++) {
//			Collections.sort(list[i]);			
//		}
	}

	public static void output() {

		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF) {
				System.out.println("INF");
				continue;
			}
			System.out.println(dist[i]);
		}

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
