import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

    static final int INF = 1_000_000_000;
    static int N, M;
    static Edge[] graph;
    static long[] dist;
    public static void solve() throws IOException {
        input();
        StringBuilder sb = new StringBuilder();
        if (!bellmanFord()) {
            System.out.println("-1");
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(dist[i]).append('\n');
                }
            }
        }
        System.out.print(sb);
    }

    private static boolean bellmanFord() {
        dist[1] = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M; j++) {
                Edge cur = graph[j];

                if (dist[cur.v] != INF && dist[cur.w] > dist[cur.v] + cur.cost) {
                    dist[cur.w] = dist[cur.v] + cur.cost;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            Edge cur = graph[i];

            if (dist[cur.v] != INF && dist[cur.w] > dist[cur.v] + cur.cost) {
                return false;
            }
        }

        return true;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new Edge[M];
        dist = new long[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[i] = new Edge(v, w, cost);
        }
        Arrays.fill(dist, INF);
    }
}

class Edge {
    int v;
    int w;
    int cost;

    public Edge(int v, int w, int cost) {
        this.v = v;
        this.w = w;
        this.cost = cost;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        Solution.solve();
    }
}
