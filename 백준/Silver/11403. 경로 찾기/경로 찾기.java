import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static int N;

    static int[][] graph;
    static int[][] result;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        result = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            bfs(i);
            visited = new boolean[N];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(String.valueOf(result[i][j]) + " ");
            }
            bw.write('\n');
        }

        bw.flush();

    }

    private static void bfs(int startNode) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (graph[startNode][i] == 1) {
                result[startNode][i] = 1;
                q.add(i);
                visited[i] = true;
            }
        }

        while (!q.isEmpty()) {
            int nextNode = q.poll();

            for (int i = 0; i < N; i++) {
                if (graph[nextNode][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    result[startNode][i] = 1;
                    q.add(i);
                }
            }
        }
    }
}