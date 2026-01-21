import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Solution {

    static final int UPHILL = 0;
    static final int DOWNHILL = 1;

    static int N, M; // N : 건물, M 도로
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    public static void solve() throws IOException {
        input();
        System.out.println(countUphill(true) - countUphill(false));
    }

    private static int countUphill(boolean preferUphill) {
        boolean[] visited = new boolean[N + 1];

        Comparator<Edge> comparator = Comparator.comparingInt(s -> s.cost);
        if (!preferUphill) {
            comparator = comparator.reversed();
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(comparator);
        visited[0] = true;
        for (Edge e : graph.get(0)) {
            pq.add(new Edge(e.to, e.cost));
        }

        int uphillCnt = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (visited[cur.to]) continue;

            visited[cur.to] = true;
            if (cur.cost == UPHILL) uphillCnt++;

            for (Edge next : graph.get(cur.to)) {
                if (!visited[next.to]) {
                    pq.add(new Edge(next.to, next.cost));
                }
            }
        }
        return uphillCnt * uphillCnt;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Edge(to, cost));
            graph.get(to).add(new Edge(from, cost));
        }
    }

}

class Edge {
    int to;
    int cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        Solution.solve();
    }
}
