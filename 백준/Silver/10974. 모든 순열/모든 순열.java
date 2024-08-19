import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static int N;
    static int[] result;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        result = new int[N];
        visited = new boolean[N];

        dfs(0);

        bw.flush();
    }

    private static void dfs(int depth) throws IOException {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                bw.write(String.valueOf(result[i] + 1) + " ");
            }
            bw.write('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                result[depth] = i;
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}