import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] wolf;
    static int[] sheep;
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(dfs(0));
    }

    static long dfs(int cur) {

        if (graph.get(cur).isEmpty()) {
            // 최하위 노드
            return sheep[cur];
        }

        long sum = 0;
        for (int next : graph.get(cur)) {
            sum += dfs(next);
        }

        return Math.max(sum + sheep[cur] - wolf[cur], 0);
    }



    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        wolf = new int[N];
        sheep = new int[N];
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            char animal = st.nextToken().charAt(0);
            int count = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken()) - 1;

            if (animal == 'W') {
                wolf[i] = count;
            } else {
                sheep[i] = count;
            }

            graph.get(to).add(i);
        }
    }
}