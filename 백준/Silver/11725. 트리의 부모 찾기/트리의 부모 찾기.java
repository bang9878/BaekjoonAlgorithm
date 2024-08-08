import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] result;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }


        visited = new boolean[N + 1];
        result = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }


        bfs(1);

        for (int i = 2; i <= N; i++) {
            bw.write(String.valueOf(result[i]));
            bw.write("\n");
        }
        bw.flush();


    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int tmp = q.poll();

            for(int next : graph.get(tmp)){
                if(!visited[next]){
                    visited[next] = true;
                    result[next] = tmp;
                    q.add(next);
                }
            }
        }
    }
}
