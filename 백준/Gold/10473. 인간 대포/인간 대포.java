import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static double startX, startY;
	static double endX, endY;

	static int N;
	static double[] result;
	static Node[] nodes;
	static boolean[] visited;
	static ArrayList<Edge>[] graph;

	static final double INF = Double.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		startX = Double.parseDouble(st.nextToken());
		startY = Double.parseDouble(st.nextToken());
		st = new StringTokenizer(br.readLine());
		endX = Double.parseDouble(st.nextToken());
		endY = Double.parseDouble(st.nextToken());

		N = Integer.parseInt(br.readLine());
		result = new double[N + 2];
		nodes = new Node[N + 2];
		graph = new ArrayList[N + 2];
		visited = new boolean[N + 2];

		for (int i = 0; i < N + 2; i++) {
			graph[i] = new ArrayList<>();
		}

		nodes[0] = new Node(startX, startY);
		nodes[N + 1] = new Node(endX, endY);

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());

			nodes[i] = new Node(x, y);
		}

		makeEdge();
		dijkstra();
		System.out.println(result[N + 1]);
	}

	public static void dijkstra() {

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, 0));

		Arrays.fill(result, INF);
		result[0] = 0;

		while (!pq.isEmpty()) {

			Edge cur = pq.poll();

			visited[cur.idx] = true;

			for (Edge next : graph[cur.idx]) {
				if (!visited[next.idx] && result[next.idx] > cur.time + next.time) {
					result[next.idx] = cur.time + next.time;
					pq.add(new Edge(next.idx, result[next.idx]));
				}
			}
		}
	}

	public static void makeEdge() {
		// 시작노드에서 나머지노드들까지 거리
		for (int i = 1; i < N + 2; i++) {
			double dis = Math.sqrt(Math.pow(nodes[0].x - nodes[i].x, 2) + Math.pow(nodes[0].y - nodes[i].y, 2));
			graph[0].add(new Edge(i, (dis * 0.2)));
		}

		// 대포들끼리의 간선
		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j < N + 1; j++) {
				double dis = Math.sqrt(Math.pow(nodes[i].x - nodes[j].x, 2) + Math.pow(nodes[i].y - nodes[j].y, 2));
				double time;

				if (dis == 50) { // 대포타고 바로 갈 수 있으면
					graph[i].add(new Edge(j, 2.0));
					graph[j].add(new Edge(i, 2.0));
				} else { // 대포 타고 걸어가야 하면
					double workDis = Math.abs(dis - 50.0);
					time = 2.0 + (workDis * 0.2);
					graph[i].add(new Edge(j, time));
					graph[j].add(new Edge(i, time));
				}

				// 걸어 감
				graph[i].add(new Edge(j, dis * 0.2));
				graph[j].add(new Edge(i, dis * 0.2));
			}
		}

		// 도착지로 오는 간선
		for (int i = 1; i < N + 1; i++) {
			double dis = Math.sqrt(Math.pow(nodes[i].x - nodes[N + 1].x, 2) + Math.pow(nodes[i].y - nodes[N + 1].y, 2));
			double time;

			if (dis == 50) { // 대포타고 바로 갈 수 있으면
				graph[i].add(new Edge(N + 1, 2.0));
			} else { // 대포 타고 걸어가야 하면
				double workDis = Math.abs(dis - 50.0);
				time = 2.0 + (workDis * 0.2);
				graph[i].add(new Edge(N + 1, time));
			}

			// 걸어 감
			graph[i].add(new Edge(N + 1, dis * 0.2));
		}

	}
}

class Edge implements Comparable<Edge> {
	int idx;
	double time;

	public Edge(int idx, double time) {
		this.idx = idx;
		this.time = time;
	}

	@Override
	public int compareTo(Edge o) {
		return Double.compare(this.time, o.time);
	}
}

class Node {
	double x;
	double y;

	public Node(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
