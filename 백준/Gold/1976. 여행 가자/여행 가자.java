import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

    static int[][] map;
    static int N, M;
    static int[] cities;

    public static void solve() throws IOException {
        input();
        if (canGoTrip()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    private static boolean canGoTrip() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        q.add(cities[0]);

        while (!q.isEmpty()) {
            Integer cur = q.poll();

            visited[cur] = true;

            for (int i = 0; i < N; i++) {
                if (map[cur][i] == 1 && !visited[i]) {
                    q.add(i);
                }
            }
        }

        for (int i = 0; i < M; i++) {
            if (!visited[cities[i]]) {
                return false;
            }
        }
        return true;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N][N];
        cities = new int[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            cities[i] = Integer.parseInt(st.nextToken()) - 1;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution.solve();
    }
}
