import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int M, N, K, count = 0;
    //static  ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[][] isPlant;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int k = 0; k < t; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            isPlant = new boolean[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    visited[i][j] = false;
                    isPlant[i][j] = false;
                }
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                isPlant[u][v] = true;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && isPlant[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
            count = 0;
            
        }
        br.close();


    }

    static void dfs(int r, int c) {
        if ((r >= 0 && r < N) && (c >= 0 && c < M)) {
            if (!visited[r][c] && isPlant[r][c]) {
                visited[r][c] = true;
                dfs(r + 1, c);
                dfs(r - 1, c);
                dfs(r, c + 1);
                dfs(r, c - 1);
            }
        }
    }

}