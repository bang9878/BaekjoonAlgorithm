import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static int N;
    static int M;
    static boolean[] visited;
    static boolean[][] graph;
    static int[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new boolean[N + 1][N + 1];
        result = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            graph[row][col] = true;
            graph[col][row] = true;
        }

        int minValue = Integer.MAX_VALUE;
        int minidx = 0;
        int sum = 0;

        for(int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            result = new int[N+1][N+1];

            bfs(i);
            sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += result[i][j];
            }
            if(sum < minValue){
                minValue = sum;
                minidx = i;
            }
        }

        System.out.println(minidx);
    }

    private static void bfs(int start) {

        Queue<Integer> q = new LinkedList<>();

        int cnt = 0;

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            if (cnt == N - 1) {
                return;
            }

            for (int i = 1; i <= N; i++) {
                if (graph[node][i] && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    result[start][i] = result[start][node]+1;
                    cnt++;
                }
            }
        }
    }
}



