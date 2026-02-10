import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

    static int N, K;
    static int[][] graph;
    static int[][] dist;
    static int answer = 1_000_000;

    public static void solve() throws IOException {
        input();
        floydWarshall();
        fireSpaceShip(0, K, 0, new boolean[N]);
        System.out.println(answer);
    }

    private static void fireSpaceShip(int depth, int start, int sum, boolean[] visited) {
        if (depth == N) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                fireSpaceShip(depth + 1, i, sum + dist[start][i], visited);
                visited[i] = false;
            }
        }
    }

    private static void floydWarshall() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = graph[i][j];
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution.solve();
    }
}
