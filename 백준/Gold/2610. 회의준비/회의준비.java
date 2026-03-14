import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int N, M; // 노드 개수, 간선 개수
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int setCnt = 0;
    static ArrayList<ArrayList<Integer>> candidates = new ArrayList<>();

    static class Edge {
        int idx;
        int cost;

        public Edge(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

    }

    public static void main(String[] args) throws IOException {
        input();
        countSet();
        solve();
    }

    static void solve() {
        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < candidates.size(); i++) {
            int min = Integer.MAX_VALUE;
            int candidateNode = 0;
            for (int n : candidates.get(i)) {
                boolean[] visited = new boolean[N];
                int res = bfs(n, visited, false);
                if (min > res) {
                    min = res;
                    candidateNode = n;
                }
            }
            ansList.add(candidateNode + 1);
        }

        Collections.sort(ansList);
        System.out.println(ansList.size());
        for (int answer : ansList) {
            System.out.println(answer);
        }
    }

    static void countSet() {
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                candidates.add(new ArrayList<>());
                bfs(i, visited, true);
                setCnt++;
            }
        }
    }

    static int bfs(int start, boolean[] visited, boolean flag) {
        Queue<Edge> q = new LinkedList<>();
        visited[start] = true;
        q.add(new Edge(start, 0));

        ArrayList<Integer> list = new ArrayList<>();
        if (flag) {
            list = candidates.get(setCnt);
            list.add(start);
        }

        int result = 0;
        while (!q.isEmpty()) {
            Edge cur  = q.poll();

            if (result < cur.cost) {
                result = cur.cost;
            }

            for (int next : graph.get(cur.idx)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new Edge(next, cur.cost + 1));
                    if(flag) list.add(next);
                }
            }
        }

        return result;
    }


    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

    }

}
